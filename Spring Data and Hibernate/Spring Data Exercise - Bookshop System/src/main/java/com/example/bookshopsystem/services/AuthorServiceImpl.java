package com.example.bookshopsystem.services;

import com.example.bookshopsystem.models.Author;
import com.example.bookshopsystem.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getRandomAuthor() {
        List<Author> authors = authorRepository.findAll();
        double randomNumber = Math.random() * 100;
        int random = (int) randomNumber;
        if (random >= authors.size()) {
           return getRandomAuthor();
        }
        return authors.get(random);
    }
}
