package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest {

    @Test
    public void should_return_parking_ticket_when_parking_boy_parks_car_given_car(){
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = new ParkingTicket();

        //when
        parkingTicket = parkingBoy.park(Car);

        //then
        assertNotNull(parkingTicket);
    }
    
}
