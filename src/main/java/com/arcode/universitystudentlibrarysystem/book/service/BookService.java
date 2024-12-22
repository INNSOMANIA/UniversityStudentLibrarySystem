package com.arcode.universitystudentlibrarysystem.book.service;

import com.arcode.universitystudentlibrarysystem.book.dto.BookDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookService {

    BookDTO getBook(long bookId) throws Exception;

    List<BookDTO> getBookList();

    void addBook(BookDTO bookDTO);

    void updateBook(long bookId, BookDTO bookDTO) throws Exception;

    void deleteBook(long bookId) throws Exception;
}
