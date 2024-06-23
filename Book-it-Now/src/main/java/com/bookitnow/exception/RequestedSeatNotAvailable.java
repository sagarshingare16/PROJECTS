package com.bookitnow.exception;

public class RequestedSeatNotAvailable extends RuntimeException{
    public RequestedSeatNotAvailable(){
        super("Requested seat not available..");
    }
}
