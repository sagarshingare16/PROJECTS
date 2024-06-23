package com.bookitnow.exception;

public class ShowNotExits extends RuntimeException{
    public ShowNotExits(){
        super("Show does not exits");
    }
}
