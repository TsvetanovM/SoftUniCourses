package com.example.bookshopsystem.services;

import com.example.bookshopsystem.models.Author;

import java.io.IOException;

public interface AuthorService {
    Author getRandomAuthor();
    void seedAuthors() throws IOException;
    void findAuthorsWithABookBefore1990_2();
    void findAuthorsByNumberOfBooksDesc_3();
}
