package com.example.pathfinder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Messages extends BaseEntity {
    private LocalDateTime dateTime;
    @Column(columnDefinition = "TEXT")
    private String textContent;
    @ManyToOne
    private User author;
    @ManyToOne
    private User recipient;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Messages setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public Messages setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Messages setAuthor(User author) {
        this.author = author;
        return this;
    }

    public User getRecipient() {
        return recipient;
    }

    public Messages setRecipient(User recipient) {
        this.recipient = recipient;
        return this;
    }
}
