package com.example.bookshopsystem.services;

import com.example.bookshopsystem.models.Category;
import com.example.bookshopsystem.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORIES_RESOURCE_PATH = "C:\\Users\\tsvet\\Desktop\\files\\categories.txt";

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getRandomCategories() {
        long start = getRandomNumber(categoryRepository.count()-1);
        long end = start + 1;
        List<Long> range = new ArrayList<>();
        range.add(start);
        range.add(end);
        return categoryRepository.findCategoriesByIdIn(range);
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(CATEGORIES_RESOURCE_PATH))
                .stream()
                .filter(row -> !row.isBlank())
                .forEach(row -> {
                    String name = row.trim();
                    var category = new Category();
                    category.setName(name);
                    categoryRepository.save(category);
                });
    }

    private long getRandomNumber(long maxNumber) {
        long number = (long) (Math.random() * 100);
        if (number > maxNumber) {
            return getRandomNumber(maxNumber);
        }
        return number;
    }
}
