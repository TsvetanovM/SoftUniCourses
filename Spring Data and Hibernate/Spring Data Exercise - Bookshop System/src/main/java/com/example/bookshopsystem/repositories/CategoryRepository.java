package com.example.bookshopsystem.repositories;

import com.example.bookshopsystem.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Set<Category> findCategoriesByNameIsLike(String name);
}
