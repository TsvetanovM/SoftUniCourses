package com.example.bookshopsystem.repositories;

import com.example.bookshopsystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {
    Set<Book> findAllByReleaseDateAfter(LocalDate date);
    Set<Book> findAllByReleaseDateBefore(LocalDate date);
}
