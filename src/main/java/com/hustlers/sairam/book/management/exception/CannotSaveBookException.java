package com.hustlers.sairam.book.management.exception;

public class CannotSaveBookException extends RuntimeException{
    public CannotSaveBookException(String errorMessage){
        super(errorMessage);
    }
}
