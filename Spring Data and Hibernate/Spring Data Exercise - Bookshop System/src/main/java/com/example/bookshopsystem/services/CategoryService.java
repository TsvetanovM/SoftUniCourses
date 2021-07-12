package com.example.bookshopsystem.services;

import com.example.bookshopsystem.exceptions.NoSuchCategoriesFoundException;
import com.example.bookshopsystem.models.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories() throws NoSuchCategoriesFoundException;
}
