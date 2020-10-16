package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {

    @Test
    public void should_return_parking_ticket_when_parking_boy_parks_car_given_car(){
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }
    
    @Test
    public void should_return_correct_parked_car_when_parking_boy_receive_parking_ticket_given_parking_ticket(){
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //when
        Car fetchedCar = parkingBoy.fetchCar(parkingTicket);
        
        //then
        assertSame(car, fetchedCar);

    }
    
    @Test
    public void should_return_two_cars_when_fetched_given_parking_tickets(){
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(car1);
        ParkingTicket parkingTicket2 = parkingBoy.park(car2);
        
        //when
        Car fetchedCar1 = parkingBoy.fetchCar(parkingTicket1);
        Car fetchedCar2 = parkingBoy.fetchCar(parkingTicket2);
        
        //then
        assertSame(car1, fetchedCar1);
        assertSame(car2, fetchedCar2);
    }
    
    @Test
    public void should_not_return_car_when_fetching_a_car_given_wrong_ticket(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        
        //when
        Car noCarFetched = parkingBoy.fetchCar(new ParkingTicket());
        
        //then
        assertNotEquals(null, noCarFetched);
    }

    @Test
    public void should_not_return_a_car_when_fetching_car_given_no_ticket(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        Car noCarFetched = parkingBoy.fetchCar(null);

        //then
        assertEquals(null, noCarFetched);

    }

    @Test
    public void should_not_return_a_car_when_fetching_car_given_used_ticket(){
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // when
        Car carFetched = parkingBoy.fetchCar(parkingTicket);
        Car noCarFetched = parkingBoy.fetchCar(parkingTicket);

        // then
        assertEquals(null, noCarFetched);
    }

}
