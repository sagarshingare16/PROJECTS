package com.bookitnow.exception;

public class MovieAlreadyPresent extends RuntimeException{
    public MovieAlreadyPresent() {
        super("Movie already present with given name..");
    }
}
