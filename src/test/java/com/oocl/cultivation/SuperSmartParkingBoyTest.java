package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SuperSmartParkingBoyTest {
    @Test
    public void should_park_on_the_lot_which_contains_larger_available_position_rate_when_parking_given_a_super_smart_parking_boy(){
        //given
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(5);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        superSmartParkingBoy.park(car1);
        superSmartParkingBoy.park(car2);
        superSmartParkingBoy.park(car3);
        superSmartParkingBoy.park(car4);
        parkingLots.add(parkingLot2);
        ParkingTicket parkingTicket = superSmartParkingBoy.park(car5);

        //then
        assertNotNull(parkingTicket);

    }

}