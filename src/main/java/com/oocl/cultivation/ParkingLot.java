package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private static int parkingLotCapacity;
    private Map<ParkingTicket, Car> parkingTicketCarMap = new HashMap<>();

    public ParkingLot(int parkingLotCapacity) {
        this.parkingLotCapacity = parkingLotCapacity;
    }

    public ParkingLot() {
        parkingLotCapacity = 10;
    }


    public ParkingTicket park(Car car){
        if(checkCapacity()) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkingTicketCarMap.put(parkingTicket, car);
            return parkingTicket;
        }
        return null;
    }

    public Car fetchCar(ParkingTicket parkingTicket){
        if(parkingTicketCarMap.containsKey(parkingTicket)){
            Car validTicket = parkingTicketCarMap.get(parkingTicket);
            parkingTicketCarMap.remove(parkingTicket);
            return validTicket;
        }
        throw new UnrecognizedParkingTicketException("InvalidParkingTicket!");
    }

    public boolean checkCapacity() {
        return parkingTicketCarMap.size() < parkingLotCapacity;
    }
}
