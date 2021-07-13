package com.example.bookshopsystem.services;

import com.example.bookshopsystem.models.Author;
import com.example.bookshopsystem.models.Book;
import com.example.bookshopsystem.repositories.AuthorRepository;
import com.example.bookshopsystem.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final String AUTHORS_RESOURCE_PATH = "C:\\Users\\tsvet\\Desktop\\files\\authors.txt";

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }
        Files.readAllLines(Path.of(AUTHORS_RESOURCE_PATH))
                .forEach(row -> {
                    String[] names = row.split("\\s+");
                    var author = new Author();
                    author.setFirstName(names[0]);
                    author.setLastName(names[1]);
                    authorRepository.save(author);
                });
    }

    @Override
    public void findAuthorsWithABookBefore1990_2() {
        Set<Book> books = bookRepository.findAllByReleaseDateBefore(LocalDate.of(1990, 1, 1));
        Set<Author> authors = authorRepository.findByBooksIn(books);
        authors.forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));
    }

}
