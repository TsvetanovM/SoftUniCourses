package com.example.bookshopsystem.services;

import com.example.bookshopsystem.enums.AgeRestriction;
import com.example.bookshopsystem.enums.Edition;
import com.example.bookshopsystem.models.Author;
import com.example.bookshopsystem.models.Book;
import com.example.bookshopsystem.models.Category;
import com.example.bookshopsystem.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private static final String BOOKS_RESOURCE_PATH = "C:\\Users\\tsvet\\Desktop\\files\\books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


    @Override
    public void findBooksAfter2000_1() {
        Set<Book> allByReleaseDateAfter = bookRepository
                .findAllByReleaseDateAfter(LocalDate
                        .of(2000,12,31));

        allByReleaseDateAfter.stream().map(Book::getTitle).forEach(System.out::println);
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }
        Files.readAllLines(Path.of(BOOKS_RESOURCE_PATH))
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
