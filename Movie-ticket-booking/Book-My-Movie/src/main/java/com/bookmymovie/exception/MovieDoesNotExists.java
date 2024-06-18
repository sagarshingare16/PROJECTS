package com.bookmymovie.exception;

public class MovieDoesNotExists extends RuntimeException{
    public MovieDoesNotExists() {
        super("Movie dose not Exists");
    }
}
