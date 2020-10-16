package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public static final int CAPACITY = 1;
    private Map<ParkingTicket, Car> parkingTicketCarMap = new HashMap<>();

    public ParkingTicket park(Car car) {
        if(checkCapacity()) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkingTicketCarMap.put(parkingTicket, car);
            return parkingTicket;
        }
            return null;
    }

    public Car fetchCar(ParkingTicket parkingTicket){
        if(parkingTicketCarMap.containsKey(parkingTicket)){
            return null;
        }
        return parkingTicketCarMap.get(parkingTicket);
    }

    public boolean checkCapacity() {
        return parkingTicketCarMap.size() <= CAPACITY;
    }
}
