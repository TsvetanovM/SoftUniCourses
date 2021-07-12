package com.example.bookshopsystem;

import com.example.bookshopsystem.enums.AgeRestriction;
import com.example.bookshopsystem.enums.Edition;
import com.example.bookshopsystem.exceptions.NoSuchCategoriesFoundException;
import com.example.bookshopsystem.models.Author;
import com.example.bookshopsystem.models.Book;
import com.example.bookshopsystem.models.Category;
import com.example.bookshopsystem.repositories.AuthorRepository;
import com.example.bookshopsystem.repositories.BookRepository;
import com.example.bookshopsystem.repositories.CategoryRepository;
import com.example.bookshopsystem.services.AuthorService;
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
    private static final String RESOURCE_PATH = "C:\\Users\\tsvet\\Desktop\\files\\";
    private static final String AUTHORS_FILE_NAME = "authors.txt";
    private static final String BOOKS_FILE_NAME = "books.txt";
    private static final String CATEGORIES_FILE_NAME = "categories.txt";

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public ConsoleRunner(AuthorService authorService, CategoryService categoryService, AuthorRepository authorRepository, BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        try {
            seedAuthors();
            seedCategories();
            seedBooks();
        } catch (IOException e) {
            System.out.println("File path not found");
        }
    }

    private void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(RESOURCE_PATH + AUTHORS_FILE_NAME))
                .forEach(row -> {
                    String[] names = row.split("\\s+");
                    var author = new Author();
                    author.setFirstName(names[0]);
                    author.setLastName(names[1]);
                    authorRepository.save(author);
                });
    }

    private void seedCategories() throws IOException {
        Files.readAllLines(Path.of(RESOURCE_PATH + CATEGORIES_FILE_NAME))
                .stream()
                .filter(row -> !row.isBlank())
                .forEach(row -> {
                    String name = row.trim();
                    var category = new Category();
                    category.setName(name);
                    categoryRepository.save(category);
                });
    }

    private void seedBooks() throws IOException {
        Files.readAllLines(Path.of(RESOURCE_PATH + BOOKS_FILE_NAME))
                .forEach(row -> {
                    String[] data = row.split("\\s+");
                    Author author = authorService.getRandomAuthor();
                    Edition edition = Edition.values()[Integer.parseInt(data[0])];
                    LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
                    int copies = Integer.parseInt(data[2]);
                    BigDecimal price = new BigDecimal(data[3]);
                    AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
                    String title = Arrays.stream(data)
                            .skip(5)
                            .collect(Collectors.joining(" "));

                    Set<Category> categories = categoryService.getRandomCategories();

                    var book = new Book(title, edition, price, releaseDate,
                                ageRestriction, author, categories, copies);
                        bookRepository.save(book);
                });
    }
}
