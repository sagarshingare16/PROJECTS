package com.bookmymovie.advice;

import com.bookmymovie.exception.MovieAlreadyPresentWithSameNameAndLanguage;
import com.bookmymovie.exception.ShowDoesNotExists;
import com.bookmymovie.exception.TheaterDoesNotExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AdminErrorController {

    @ExceptionHandler(MovieAlreadyPresentWithSameNameAndLanguage.class)
    public ResponseEntity<ErrorDetails> handleMovieAlreadyPresent(MovieAlreadyPresentWithSameNameAndLanguage exception){
        return new ResponseEntity<>(new ErrorDetails(HttpStatus.BAD_REQUEST,exception.getMessage()
                , LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TheaterDoesNotExists.class)
    public ResponseEntity<ErrorDetails> handleTheaterDoesNotExits(TheaterDoesNotExists exception){
        return new ResponseEntity<>(new ErrorDetails(HttpStatus.BAD_REQUEST,exception.getMessage(),
                LocalDateTime.now()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ShowDoesNotExists.class)
    public ResponseEntity<ErrorDetails> handleShowDoesNotExits(ShowDoesNotExists exception){
        return new ResponseEntity<>(new ErrorDetails(HttpStatus.BAD_REQUEST,exception.getMessage(),
                LocalDateTime.now()),HttpStatus.BAD_REQUEST);
    }

    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGenericException(Exception exception){
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

}
