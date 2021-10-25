package com.example.pathfinder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Pictures extends BaseEntity {

    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String url;
    @ManyToOne
    private User author;
    @ManyToOne
    private Route route;

    public String getTitle() {
        return title;
    }

    public Pictures setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Pictures setUrl(String url) {
        this.url = url;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Pictures setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Route getRoute() {
        return route;
    }

    public Pictures setRoute(Route route) {
        this.route = route;
        return this;
    }
}
