package com.bookitnow.exception;

public class UserAlreadyRegistered extends RuntimeException{
    public UserAlreadyRegistered(){
        super("User already registered..");
    }
}
