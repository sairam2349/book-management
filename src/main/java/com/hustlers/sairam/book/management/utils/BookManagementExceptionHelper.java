package com.hustlers.sairam.book.management.utils;

import com.hustlers.sairam.book.management.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BookManagementExceptionHelper extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {InvalidIsbnException.class})
    public ResponseEntity<ErrorResponse> handleInvalidIsbnException(InvalidIsbnException e){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException e){

        ErrorResponse errorResponse = new ErrorResponse(1001, e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BookAlreadyExistsException.class})
    public ResponseEntity<ErrorResponse> handleBookAlreadyExistsException(BookAlreadyExistsException e){

        ErrorResponse errorResponse = new ErrorResponse(2002, e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {CannotSaveBookException.class})
    public ResponseEntity<ErrorResponse> handleCannotSaveBookException(CannotSaveBookException e){

        ErrorResponse errorResponse = new ErrorResponse(2004, e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {CannotUpdateBookException.class})
    public ResponseEntity<ErrorResponse> handleCannotUpdateBookException(CannotUpdateBookException e){

        ErrorResponse errorResponse = new ErrorResponse(2006, e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

}
