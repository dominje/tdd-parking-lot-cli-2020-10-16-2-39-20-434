package com.oocl.cultivation;

import com.oocl.cultivation.exception.ParkingLotFullException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SmartParkingBoy {

    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLots = parkingLot;
    }

    public ParkingTicket park(Car car) {
        ParkingLot parkingLott = parkingLots.stream()
                        .min(Comparator.comparing(ParkingLot::getCurrentParkingLotCapacity)).orElse(null);
        if (Objects.nonNull(parkingLott)) {
            return parkingLott.park(car);
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

