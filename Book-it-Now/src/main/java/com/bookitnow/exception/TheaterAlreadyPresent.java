package com.bookitnow.exception;

public class TheaterAlreadyPresent extends RuntimeException{
    public TheaterAlreadyPresent(){
        super("Theater already present..");
    }
}
