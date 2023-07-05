package com.hustlers.sairam.book.management.service;

import com.hustlers.sairam.book.management.exception.BookAlreadyExistsException;
import com.hustlers.sairam.book.management.exception.BookNotFoundException;
import com.hustlers.sairam.book.management.exception.CannotSaveBookException;
import com.hustlers.sairam.book.management.exception.CannotUpdateBookException;
import com.hustlers.sairam.book.management.model.dto.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    private static List<Book> books = initializeData();
    private static List<Book> initializeData(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book( "Na istam", "RGV"));
        books.add(new Book( "I too had a Love Story", "Ravinder Singh"));
        books.add(new Book( "One night at the call center", "Chethan Bhagath"));
        books.add(new Book( "Can Love Happen Twice", "Ravinder Singh"));
        books.add(new Book( "Two States", "Chethan Bhagath"));
        return books;
    }

    public List<Book> getAllBooks(){
       return books;
    }

    public String deleteBook(int intIsbn){
        String result = "";
        for(int i=0;i<books.size();i++){
            if(intIsbn == books.get(i).getIsbn()){
                books.remove(i);
                result = "Requested Book is Deleted";
            }
        }
        if(result.equals("")) throw new BookNotFoundException("Book not found.");
        return result;
    }

    public Book getBook(int intIsbn){
        Book book = null;
        for(int i=0; i<books.size();i++){
            if(intIsbn == books.get(i).getIsbn()) {
                return books.get(i);
            }
        }
        if(book==null) throw new BookNotFoundException("Book Not Found");
        return book;
    }



    public Book addBook(Book book){

        Book newBook = null;

        for(int i=0 ; i<books.size() ; i++){
            if(book.getTitle().equals(books.get(i).getTitle())){
                throw new BookAlreadyExistsException("Book titled: '"+book.getTitle()+"' already EXISTS.");
            }
        }

        books.add(new Book(book.getTitle(),book.getAuthor()));
        for(int i=0 ; i<books.size() ; i++) {
            if (book.getTitle().equals(books.get(i).getTitle())) {
                return newBook = books.get(i);
            }
        }
        return newBook;
    }

    public Book updateBook(int intIsbn,Book book){
        Book updatedBook = null;

        if(intIsbn > books.size()){
            throw new BookNotFoundException("Book Not Found");
        } else {
            for(int i=0 ; i<books.size() ; i++) {
                if (intIsbn == books.get(i).getIsbn()) {
                    if(book.getTitle().equals(books.get(i).getTitle())
                            && book.getAuthor().equals(books.get(i).getAuthor())){
                        throw new CannotUpdateBookException("Please provide new values for either Title and Author");
                    } else {
                        updatedBook = books.set(i, book);
                    }
                }
            }
        }

        return updatedBook;
    }
}


