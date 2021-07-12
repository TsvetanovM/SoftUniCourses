package com.example.bookshopsystem.services;

import com.example.bookshopsystem.models.Category;
import com.example.bookshopsystem.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
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

    private long getRandomNumber(long maxNumber) {
        long number = (long) (Math.random() * 100);
        if (number > maxNumber) {
            return getRandomNumber(maxNumber);
        }
        return number;
    }
}
