package com.tu.library.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;
    private final String title;
    private final String author;
    private final Date publishDate;
    private boolean status;

//    @OneToOne(mappedBy = "book")
//    private TakenDetail takenDetail;

    public Book() {
        this(0, null, null, null, false);
    }

    public Book(String title, String author, Date publishDate, boolean status) {
        this(0, title, author, publishDate, status);
    }

    public Book(long id, String title, String author, Date publishDate, boolean status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
