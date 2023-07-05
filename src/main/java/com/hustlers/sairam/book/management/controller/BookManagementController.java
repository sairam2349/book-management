package com.hustlers.sairam.book.management.controller;

import com.hustlers.sairam.book.management.exception.CannotSaveBookException;
import com.hustlers.sairam.book.management.model.dto.Book;
import com.hustlers.sairam.book.management.repository.BookRepository;
import com.hustlers.sairam.book.management.service.BookService;
import com.hustlers.sairam.book.management.exception.InvalidIsbnException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@Validated
@RequestMapping("/books")
public class BookManagementController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    public static final String INVALID = "Please provide a positive integer.";
    public static final String CANNOT_SAVE = "Cannot save a book without Title or Author";

    @GetMapping("/getAll")
    public List<Book> getAllBooks() {
//       return bookService.getAllBooks();
        return bookRepository.findAll();
    }

    @DeleteMapping("/delete/{isbn}")
    public String deleteBook(@PathVariable String isbn){
        int intIsbn;

        try {
            intIsbn = Integer.parseInt(isbn);
            if (intIsbn > 0) {
                return bookService.deleteBook(intIsbn);
            } else {
                throw new InvalidIsbnException(INVALID);
            }
        }
        catch (NumberFormatException e){
            throw new InvalidIsbnException(INVALID);
        }
    }

    @GetMapping("/get/{isbn}")
    public Book getBook( @PathVariable String isbn) {

        int intIsbn;
        Book book;

        try {
            intIsbn = Integer.parseInt(isbn);
            if (intIsbn > 0) {
                book = bookService.getBook(intIsbn);
            } else {
                throw new InvalidIsbnException(INVALID);
            }
        }
        catch (NumberFormatException e){
            throw new InvalidIsbnException(INVALID);
        }

        return book;
    }


    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){

        Book savedBook;

        if(book.getTitle().isEmpty() || book.getAuthor().isEmpty()){
            throw new CannotSaveBookException(CANNOT_SAVE);
        }

        savedBook = bookService.addBook(book);
        return new  ResponseEntity<>(savedBook, HttpStatus.OK);
    }

    @PutMapping("/update/{isbn}")
    public Book updateBook(@PathVariable String isbn,
                           @RequestBody Book book){
        int intIsbn;
        Book updatedBook;

        if(isbn.isEmpty() || book.getTitle().isEmpty() || book.getAuthor().isEmpty()){
            throw new CannotSaveBookException(CANNOT_SAVE);
        }

        try {
            intIsbn = Integer.parseInt(isbn);
            if (intIsbn > 0) {
                updatedBook = bookService.updateBook(intIsbn,book);
            } else {
                throw new InvalidIsbnException(INVALID);
            }
        }
        catch (NumberFormatException e){
            throw new InvalidIsbnException(INVALID);
        }

        return updatedBook;
    }
}


