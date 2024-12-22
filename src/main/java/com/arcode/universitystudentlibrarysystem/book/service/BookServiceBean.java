package com.arcode.universitystudentlibrarysystem.book.service;

import com.arcode.universitystudentlibrarysystem.book.dto.BookDTO;
import com.arcode.universitystudentlibrarysystem.book.persistence.db.BookRepository;
import com.arcode.universitystudentlibrarysystem.book.persistence.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceBean implements BookService {

    private final BookRepository<Book> bookRepository;

    @Override
    public BookDTO getBook(long bookId) throws Exception {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            return new BookDTO(
                    book.getId(),
                    book.getName(),
                    book.getDescription(),
                    book.getWriter());

        } else {
            throw new Exception("Book is not found in the system");
        }
    }

    @Override
    public List<BookDTO> getBookList() {
        return bookRepository.findAll().stream().map(
                        book -> new BookDTO(
                                book.getId(),
                                book.getName(),
                                book.getDescription(),
                                book.getWriter()))
                .collect(Collectors.toList());
    }

    @Override
    public void addBook(BookDTO bookDTO) {
        Book book = Book.builder()
                .id(bookDTO.getId())
                .name(bookDTO.getName())
                .description(bookDTO.getDescription())
                .writer(bookDTO.getWriter())
                .build();
        bookRepository.save(book);
    }

    @Override
    public void updateBook(long bookId, BookDTO bookDTO) throws Exception {
        final Optional<Book> resultBook = bookRepository.findById(bookId);
        if (resultBook.isPresent()) {
            resultBook.get().setName(bookDTO.getName());
            resultBook.get().setDescription(bookDTO.getDescription());
            resultBook.get().setWriter(bookDTO.getWriter());

            bookRepository.save(resultBook.get());
        } else {
            throw new Exception("Book with id " + bookId + " does not update.");
        }
    }

    @Override
    public void deleteBook(long bookId) throws Exception {
        final Optional<Book> possibleBook = bookRepository.findById(bookId);
        if (possibleBook.isPresent()) {
            final Book book = possibleBook.get();
            bookRepository.delete(possibleBook.get());
        } else {
            throw new Exception("Book with id " + bookId + " does not exist.");
        }
    }
}