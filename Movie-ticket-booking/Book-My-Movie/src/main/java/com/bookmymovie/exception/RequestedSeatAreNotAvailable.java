package com.bookmymovie.exception;

public class RequestedSeatAreNotAvailable extends RuntimeException{
    public RequestedSeatAreNotAvailable() {
        super("Requested Seats Are Not Available");
    }
}
