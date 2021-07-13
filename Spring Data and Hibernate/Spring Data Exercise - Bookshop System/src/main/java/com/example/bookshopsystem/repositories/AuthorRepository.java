package com.example.bookshopsystem.repositories;

import com.example.bookshopsystem.models.Author;
import com.example.bookshopsystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Set<Author> findByBooksIn(Set<Book> books);
    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    Set<Author> findAllByBooksCountDesc();
}
