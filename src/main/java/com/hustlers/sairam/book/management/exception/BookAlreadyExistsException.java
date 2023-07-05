package com.hustlers.sairam.book.management.exception;

public class BookAlreadyExistsException extends  RuntimeException{
    public BookAlreadyExistsException(String errorMessge){
        super(errorMessge);
    }
}
