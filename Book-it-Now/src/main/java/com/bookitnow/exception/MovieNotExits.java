package com.bookitnow.exception;

public class MovieNotExits extends RuntimeException{
    public MovieNotExits(){
        super("Movie does not exits..");
    }
}
