package ru.homework.booklibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.homework.booklibrary.dto.BookDto;
import ru.homework.booklibrary.dto.ExtBookDto;
import ru.homework.booklibrary.services.interfaces.BookService;

import java.util.List;

@RestController
@RequestMapping("/book/")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("all")
    public List<BookDto> getAllBooks() {
        return bookService.getBooks();
    }

    @PostMapping("add")
    public BookDto addBook(@RequestBody ExtBookDto bookDto) {
        return bookService.addBook(bookDto);
    }

    @GetMapping("{bookId}")
    public BookDto getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }

    @PutMapping("{bookId}")
    public BookDto updateBook(@PathVariable Long bookId, @RequestBody ExtBookDto bookDto) {
        bookDto.setId(bookId);
        return bookService.updateBook(bookDto);
    }

    @DeleteMapping("{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }

    @GetMapping("catalog")
    public List<BookDto> getBooksByCatalog(@RequestParam("id") Long catalogId) {
        return bookService.getBooks(catalogId);
    }

}
