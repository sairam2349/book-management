package com.hustlers.sairam.book.management.exception;

public class CannotUpdateBookException extends RuntimeException{
    public CannotUpdateBookException(String errorMessage){
        super(errorMessage);
    }
}
