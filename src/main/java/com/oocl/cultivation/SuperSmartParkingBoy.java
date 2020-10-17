package com.oocl.cultivation;

import com.oocl.cultivation.exception.ParkingLotFullException;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SuperSmartParkingBoy {
    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLots = parkingLot;
    }

    // larger position rate = getPositionsAvailable()/getParkingLotCapacity()
    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getPositionRate)).orElse(null);
        if (Objects.nonNull(parkingLot)) {
            return parkingLot.park(car);
        }
        throw new ParkingLotFullException("Not enough position.");
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.validateParkingTicket(parkingTicket);
        }
        return null;
    }

}
