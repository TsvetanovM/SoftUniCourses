package com.example.bookshopsystem.repositories;

import com.example.bookshopsystem.models.Author;
import com.example.bookshopsystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Set<Author> findByBooksIn(Set<Book> books);
}
