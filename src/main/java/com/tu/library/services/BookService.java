package com.tu.library.services;

import com.tu.library.entity.Book;
import com.tu.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    public List<Book> findBooksByStatus(boolean status) {
        return bookRepo.findBooksByStatus(status);
    }

    public Book findById(long id) {
        return bookRepo.findById(id);
    }
}
