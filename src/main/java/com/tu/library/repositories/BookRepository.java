package com.tu.library.repositories;

import com.tu.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findBooksByStatus(boolean status);

    Book findById(long id);

}
