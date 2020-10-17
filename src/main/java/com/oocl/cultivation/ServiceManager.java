package com.oocl.cultivation;

import com.oocl.cultivation.exception.ParkingBoyNotInManagementListException;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager extends ParkingBoy {

    private final List<ParkingBoy> parkingLotManagementList = new ArrayList<>();

    public ServiceManager(List<ParkingLot> parkingLot) {
        super(parkingLot);
    }

    public void addParkingBoyToManagementList(ParkingBoy parkingBoy) {
        parkingLotManagementList.add(parkingBoy);
    }

    public ParkingTicket askParkingBoyToParkCar(Car car, ParkingBoy parkingBoy) {
        if (parkingLotManagementList.contains(parkingBoy)) {
            return parkingBoy.park(car);
        } else {
            throw new ParkingBoyNotInManagementListException("Parking Boy not in Management List!");
        }
    }

    public Car askParkingBoyToFetchCar(ParkingTicket ticket, ParkingBoy parkingBoy) {
        if (parkingLotManagementList.contains(parkingBoy)) {
            return parkingBoy.fetchCar(ticket);
        } else {
            throw new ParkingBoyNotInManagementListException("Parking Boy not in Management List!");
        }
    }

}
