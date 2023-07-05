package com.hustlers.sairam.book.management.exception;

public class InvalidIsbnException extends RuntimeException{
    public InvalidIsbnException(String errorMessage){
        super(errorMessage);
    }
}
