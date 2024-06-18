package com.bookmymovie.exception;

public class ShowDoesNotExists extends RuntimeException{

    public ShowDoesNotExists() {
        super("Show does not exists");
    }
}
