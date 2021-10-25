package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.enums.CategoryName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Categories extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryName name;
    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryName getName() {
        return name;
    }

    public Categories setName(CategoryName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Categories setDescription(String description) {
        this.description = description;
        return this;
    }

}
