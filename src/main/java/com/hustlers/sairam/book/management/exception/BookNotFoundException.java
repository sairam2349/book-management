package com.hustlers.sairam.book.management.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
