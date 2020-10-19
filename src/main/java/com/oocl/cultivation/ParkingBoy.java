package com.oocl.cultivation;

import exception.ParkingLotFullException;
import java.util.List;

public class ParkingBoy {

    private final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLots = parkingLot;
    }

    public ParkingTicket park(Car car)
    {
        for(ParkingLot parkingLot : parkingLots) {
            if(parkingLot.checkCapacity()){
                return parkingLot.park(car);
            }
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
