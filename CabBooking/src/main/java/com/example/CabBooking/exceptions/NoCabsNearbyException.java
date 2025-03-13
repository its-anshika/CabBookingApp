package com.example.CabBooking.exceptions;

public class NoCabsNearbyException extends RuntimeException {
    public NoCabsNearbyException(String message) {
        super(message);

    }
}
