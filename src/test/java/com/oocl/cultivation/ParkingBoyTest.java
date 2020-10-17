package com.oocl.cultivation;

import com.oocl.cultivation.exception.NoParkingTicketException;
import com.oocl.cultivation.exception.ParkingLotFullException;
import com.oocl.cultivation.exception.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        UnrecognizedParkingTicketException thrown = assertThrows(
                UnrecognizedParkingTicketException.class,
                () -> parkingBoy.fetchCar(new ParkingTicket()),
                "Expected park() to throw, but it didn't"
        );

        // then
        assertTrue(thrown.getMessage().contains("Unrecognized Parking Ticket!"));

    }

    @Test
    public void should_not_return_a_car_when_fetching_car_given_no_ticket(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());


        //when
        NoParkingTicketException thrown = assertThrows(
                NoParkingTicketException.class,
                () -> parkingBoy.fetchCar(null),
                "Expected park() to throw, but it didn't"
        );

        // then
        assertTrue(thrown.getMessage().contains("Please provide your parking ticket."));

    }

    @Test
    public void should_not_return_a_car_when_fetching_car_given_used_ticket(){
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // when
        Car carFetched = parkingBoy.fetchCar(parkingTicket);
        //when
        UnrecognizedParkingTicketException thrown = assertThrows(
                UnrecognizedParkingTicketException.class,
                () -> parkingBoy.fetchCar(parkingTicket),
                "Expected park() to throw, but it didn't"
        );

        // then
        assertTrue(thrown.getMessage().contains("Unrecognized Parking Ticket!"));

    }

    @Test
    public void should_be_failed_parking_when_parking_a_car_given_that_the_capacity_is_only_one_and_is_taken(){
        //given
        Car car = new Car();
        Car car1 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        ParkingTicket parkingTicket1 = parkingBoy.park(car);

        //when
        ParkingLotFullException thrown = assertThrows(
                ParkingLotFullException.class,
                () -> parkingBoy.park(car1),
                "Expected fetch() to throw, but it didn't"
        );

        //then
        assertTrue(thrown.getMessage().contains("Not enough position."));

    }

    @Test
    public void should_throw_an_exception_car_when_fetching_given_wrong_ticket(){
    
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(car);
        Car carFetched = parkingBoy.fetchCar(parkingTicket);

        
        //when
        UnrecognizedParkingTicketException thrown = assertThrows(
                UnrecognizedParkingTicketException.class,
                () -> parkingBoy.fetchCar(parkingTicket),
                "Expected fetch() to throw, but it didn't"
        );

        // then
        assertTrue(thrown.getMessage().contains("Unrecognized Parking Ticket!"));

    }

    @Test
    public void should_throw_an_exception_car_when_fetching_given_no_ticket(){

        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        NoParkingTicketException thrown = assertThrows(
                NoParkingTicketException.class,
                () -> parkingBoy.fetchCar(null),
                "Expected fetch() to throw, but it didn't"
        );

        // then
        assertTrue(thrown.getMessage().contains("Please provide your parking ticket."));
    }

    @Test
    public void should_throw_an_exception_when_parking_a_car_given_parking_lot_is_full(){
    
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        ParkingTicket parkingTicket = parkingBoy.park(car);
        
        //when
        ParkingLotFullException thrown = assertThrows(
                ParkingLotFullException.class,
                () -> parkingBoy.park(car),
                "Expected fetch() to throw, but it didn't"
        );

        //then
        assertTrue(thrown.getMessage().contains("Not enough position."));
    }
    
    @Test
    public void should_park_sequentially_when_parking_given_two_parking_lots_first_one_is_full() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));

        //when
        ParkingTicket parkingTicket1 = parkingBoy.park(car1);
        parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket2 =parkingBoy.park(car2);

        //then
        assertNotNull(parkingTicket1);
        assertNotNull(parkingTicket2);

    }

    @Test
    public void should_park_on_the_lot_which_contains_more_empty_position_when_parking_given_a_smart_parking_boy() {
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
        parkingLots.add(parkingLot2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);
        smartParkingBoy.park(car3);
        smartParkingBoy.park(car4);
        ParkingTicket parkingTicket = smartParkingBoy.park(car5);

        //then
        assertNotNull(parkingTicket);
    }
    
}
