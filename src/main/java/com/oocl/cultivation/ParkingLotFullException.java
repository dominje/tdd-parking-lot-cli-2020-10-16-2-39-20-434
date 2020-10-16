package com.oocl.cultivation;

public class ParkingLotFullException extends RuntimeException {
    public ParkingLotFullException(String message) {
        super("Not enough position.");
    }
}
