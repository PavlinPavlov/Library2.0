package com.tu.library.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "taken_details")
public class TakenDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;

    private final Date returnDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public TakenDetail() {
        this(0, null);
    }

    public TakenDetail(Date returnDate) {
        this(0, returnDate);
    }

    public TakenDetail(long id, Date returnDate) {
        this.id = id;
        this.returnDate = returnDate;
    }

    public long getId() {
        return id;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
