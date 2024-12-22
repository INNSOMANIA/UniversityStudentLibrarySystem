package com.arcode.universitystudentlibrarysystem.book.persistence.db;

import com.arcode.universitystudentlibrarysystem.book.persistence.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository<T extends Book> extends JpaRepository<Book , Long> {

    Optional<Book> findById(Long bookId);

    List<Book> findAll();

}
