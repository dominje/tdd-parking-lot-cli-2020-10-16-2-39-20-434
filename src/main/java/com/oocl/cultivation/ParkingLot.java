package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    Map<ParkingTicket, Car> parkingTicketCarMap = new HashMap<>();

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicketCarMap.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetchCar(ParkingTicket parkingTicket){
        if(parkingTicketCarMap.containsKey(parkingTicket)){
            return null;
        }
        return parkingTicketCarMap.get(parkingTicket);
    }
}
