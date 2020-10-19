package com.oocl.cultivation;

import exception.ParkingBoyNotInManagementListException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceManagerTest {
    @Test
    public void should_park_car_and_give_ticket_when_car_arrives_given_car(){
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot);
        ServiceManager serviceManager = new ServiceManager(parkingLotList);
        //when
        ParkingTicket parkingTicket = serviceManager.park(car);
        Car fetchedCar = serviceManager.fetchCar(parkingTicket);

        //then
        assertSame(car, fetchedCar);
    }

    @Test
    public void should_specify_parking_boy_to_fetch_car_when_parking_boy_manages_lot_given_ticket() {
        //given

        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLotList);
        ParkingBoy parkingBoy2 = new ParkingBoy(parkingLotList);
        ServiceManager serviceManager = new ServiceManager(parkingLotList);
        //when
        serviceManager.addParkingBoyToManagementList(parkingBoy1);
        serviceManager.addParkingBoyToManagementList(parkingBoy2);

        ParkingTicket parkingTicket = serviceManager.askParkingBoyToParkCar(car, parkingBoy1);
        Car fetchedCar = serviceManager.askParkingBoyToFetchCar(parkingTicket, parkingBoy2);

        //then
        assertSame(car, fetchedCar);

    }

    @Test
    public void should_throw_exception_when_asking_parking_boy_to_park_car_given_parking_boy_not_in_management_list() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        ServiceManager serviceManager = new ServiceManager(parkingLotList);

        //when
        ParkingBoyNotInManagementListException thrown = assertThrows(
                ParkingBoyNotInManagementListException.class,
                () -> serviceManager.askParkingBoyToParkCar(car, parkingBoy)
        );

        //then
        assertTrue(thrown.getMessage().contains("Parking Boy not in Management List!"));

    }

}