package com.bookitnow.exception;

public class UserNotExits extends RuntimeException{
    public UserNotExits(){
        super("User not exits..");
    }
}
