package com.hustlers.sairam.book.management.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="book")
public class Book {


    private static int bId = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int isbn;

    @NotEmpty @NotNull @Size(min = 1, max = 100)
    private String title;

    @NotEmpty @NotNull @Size(min = 1, max = 50)
    private String author;

    public Book() {
    }

    public Book(String bookTitle, String bookAuthor) {
        this.isbn = ++bId;
        this.title = bookTitle;
        this.author = bookAuthor;
    }

    public int getIsbn(){
        return isbn; }

    public void setIsbn(){
        this.isbn = isbn; }

    public String getTitle(){
        return title;
    }

    public void setTitle(){
        this.title=title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(){ this.author= author; }
}
