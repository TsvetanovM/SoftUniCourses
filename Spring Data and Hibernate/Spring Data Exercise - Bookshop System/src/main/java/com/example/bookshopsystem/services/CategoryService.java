package com.example.bookshopsystem.services;

import com.example.bookshopsystem.models.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();
    void seedCategories() throws IOException;
}
