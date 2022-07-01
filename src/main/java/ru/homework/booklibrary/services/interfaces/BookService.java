package ru.homework.booklibrary.services.interfaces;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import ru.homework.booklibrary.dao.entities.Book;
import ru.homework.booklibrary.dto.BookDto;
import ru.homework.booklibrary.dto.ExtBookDto;

import java.util.List;

@Service
public interface BookService {

    BookDto addBook(@NonNull ExtBookDto bookDto);

    void deleteBook(Long bookId);

    BookDto getBook(Long bookId);

    Book getBookById(Long bookId);

    List<BookDto> getBooks();

    List<BookDto> getBooks(Long catalogId);

    BookDto updateBook(@NonNull ExtBookDto bookDto);

}
