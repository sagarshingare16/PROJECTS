package com.bookitnow.exception;

public class ShowAlreadyExitsAtSameTime extends RuntimeException{
    public ShowAlreadyExitsAtSameTime(){
        super("Show already present at same time..");
    }
}
