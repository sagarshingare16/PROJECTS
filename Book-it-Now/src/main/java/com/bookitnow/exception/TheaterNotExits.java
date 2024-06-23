package com.bookitnow.exception;

public class TheaterNotExits extends RuntimeException{
    public TheaterNotExits(){
        super("Theater does not exits");
    }
}
