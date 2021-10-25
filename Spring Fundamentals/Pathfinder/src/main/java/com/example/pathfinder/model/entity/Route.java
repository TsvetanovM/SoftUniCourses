package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.enums.Level;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {

    @Column(columnDefinition = "LONGTEXT")
    private String gpsCoordinates;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private Level level;
    private String name;
    @ManyToOne
    private User author;
    private String videoUrl;
    @ManyToMany
    private List<Categories> categories;

    public String getGpsCoordinates() {
        return gpsCoordinates;
    }

    public Route setGpsCoordinates(String gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public Route setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Route setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Route setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public Route setCategories(List<Categories> categories) {
        this.categories = categories;
        return this;
    }
}
