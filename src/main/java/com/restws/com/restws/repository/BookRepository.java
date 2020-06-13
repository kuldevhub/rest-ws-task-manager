package com.restws.com.restws.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.restws.com.restws.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
