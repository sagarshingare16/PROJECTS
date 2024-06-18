package com.bookmymovie.exception;

public class UserDoesNotExists extends RuntimeException{
    public UserDoesNotExists() {
        super("User does not exists");
    }
}
