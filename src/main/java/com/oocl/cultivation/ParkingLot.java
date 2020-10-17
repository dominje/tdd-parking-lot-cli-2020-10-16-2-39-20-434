package com.oocl.cultivation;

import com.oocl.cultivation.exception.NoParkingTicketException;
import com.oocl.cultivation.exception.ParkingLotFullException;
import com.oocl.cultivation.exception.UnrecognizedParkingTicketException;

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
            return getParkingTicket(car);
        }
        return null;
    }

    private ParkingTicket getParkingTicket(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicketCarMap.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car validateParkingTicket(ParkingTicket parkingTicket){
        if(parkingTicketCarMap.containsKey(parkingTicket)){
            return fetchCar(parkingTicket);
        }else if(parkingTicket == null){
            throw new NoParkingTicketException("Please provide your parking ticket.");
        }
            throw new UnrecognizedParkingTicketException("Invalid Parking Ticket!");
    }

    private Car fetchCar(ParkingTicket parkingTicket) {
        Car validTicket = parkingTicketCarMap.get(parkingTicket);
        parkingTicketCarMap.remove(parkingTicket);
        return validTicket;
    }

    public boolean checkCapacity() {
        return parkingTicketCarMap.size() < parkingLotCapacity;
    }
}
