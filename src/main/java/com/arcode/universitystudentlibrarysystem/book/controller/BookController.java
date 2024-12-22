package com.arcode.universitystudentlibrarysystem.book.controller;

import com.arcode.universitystudentlibrarysystem.book.dto.BookDTO;
import com.arcode.universitystudentlibrarysystem.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    private final BookService bookService;

    @GetMapping(value = "/{bookId}")
    public BookDTO getBook(@PathVariable("bookId") long bookId) throws Exception {
        return bookService.getBook(bookId);
    }

    @GetMapping(value = "")
    public List<BookDTO> getBookList() throws Exception {
        return bookService.getBookList();
    }

    @PostMapping(value = "/add")
    public void addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
    }

    @PutMapping(value = "/{bookId}/update")
    public void updateBook(@PathVariable("bookId") long bookId, @RequestBody BookDTO bookDTO) throws Exception {
        bookService.updateBook(bookId, bookDTO);
    }

    @DeleteMapping(value = "/{bookId}/delete")
    public void deleteBook(@PathVariable("bookId") long bookId) throws Exception {
        bookService.deleteBook(bookId);
    }
}
