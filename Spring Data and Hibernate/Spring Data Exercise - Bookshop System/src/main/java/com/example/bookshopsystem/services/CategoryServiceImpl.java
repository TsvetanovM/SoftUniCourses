package com.example.bookshopsystem.services;

import com.example.bookshopsystem.exceptions.NoSuchCategoriesFoundException;
import com.example.bookshopsystem.models.Category;
import com.example.bookshopsystem.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getRandomCategories() throws NoSuchCategoriesFoundException {
        Set<Category> categories = categoryRepository.findCategoriesByNameIsLike("%")
                .stream()
                .limit(3)
                .collect(Collectors.toSet());

        if (categories.isEmpty()) {
            throw new NoSuchCategoriesFoundException();
        }
        return categories;
    }
}
