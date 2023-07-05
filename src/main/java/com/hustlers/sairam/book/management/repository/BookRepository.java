package com.hustlers.sairam.book.management.repository;

import com.hustlers.sairam.book.management.model.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
