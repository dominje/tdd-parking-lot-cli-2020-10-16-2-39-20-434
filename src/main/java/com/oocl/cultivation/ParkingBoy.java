package com.oocl.cultivation;

import com.oocl.cultivation.exception.ParkingLotFullException;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot)
    {
        parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
    }

    public ParkingTicket park(Car car)
    {
        for(ParkingLot parkingLot : parkingLots) {
            if(parkingLot.checkCapacity()){
                return parkingLot.park(car);
            }
            continue;
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
