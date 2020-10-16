package com.oocl.cultivation.exception;

public class NoParkingTicketException extends RuntimeException {
    public NoParkingTicketException(String message) {
        super("Please provide your parking ticket.");
    }
}
