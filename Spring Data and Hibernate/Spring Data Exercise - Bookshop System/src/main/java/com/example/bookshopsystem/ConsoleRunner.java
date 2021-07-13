package com.example.bookshopsystem;

import com.example.bookshopsystem.enums.AgeRestriction;
import com.example.bookshopsystem.enums.Edition;
import com.example.bookshopsystem.models.Author;
import com.example.bookshopsystem.models.Book;
import com.example.bookshopsystem.models.Category;
import com.example.bookshopsystem.services.AuthorService;
import com.example.bookshopsystem.services.BookService;
import com.example.bookshopsystem.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;


    public ConsoleRunner(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) {
        try {
            seedData();
            bookService.findBooksAfter2000_1();
            authorService.findAuthorsWithABookBefore1990_2();
        } catch (IOException e) {
            System.out.println("File path not found");
        }
    }

    private void seedData() throws IOException {
        authorService.seedAuthors();
        categoryService.seedCategories();
        bookService.seedBooks();
    }
}
