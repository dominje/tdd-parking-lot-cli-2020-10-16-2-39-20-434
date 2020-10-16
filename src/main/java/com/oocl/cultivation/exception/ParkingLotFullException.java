package com.oocl.cultivation.exception;

public class ParkingLotFullException extends RuntimeException {
    public ParkingLotFullException(String message) {
        super("Not enough position.");
    }
}
