package com.parcial.uno.parcial_uno.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.parcial.uno.parcial_uno.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findByIsbn(String isbn);
}
