package com.oocl.cultivation.exception;

public class ParkingBoyNotInManagementListException extends RuntimeException{
    public ParkingBoyNotInManagementListException(String message) {
        super("Parking Boy not in Management List!");
    }
}
