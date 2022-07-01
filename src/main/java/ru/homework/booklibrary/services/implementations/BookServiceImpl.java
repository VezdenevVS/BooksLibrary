package ru.homework.booklibrary.services.implementations;

import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.homework.booklibrary.dao.entities.BasicEntity;
import ru.homework.booklibrary.dao.entities.Book;
import ru.homework.booklibrary.dao.repositories.BooksRepository;
import ru.homework.booklibrary.dto.BookDto;
import ru.homework.booklibrary.dto.ExtBookDto;
import ru.homework.booklibrary.services.interfaces.AuthorService;
import ru.homework.booklibrary.services.interfaces.BookService;
import ru.homework.booklibrary.services.interfaces.CatalogService;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.LongFunction;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CatalogService catalogService;

    @Override
    public BookDto addBook(@NonNull ExtBookDto bookDto) {
        return createOrUpdate(bookDto, new Book());
    }

    @Override
    public void deleteBook(Long bookId) {
        booksRepository.delete(getBookById(bookId));
    }

    @Override
    public BookDto getBook(Long bookId) {
        return new BookDto(getBookById(bookId));
    }

    @Override
    public Book getBookById(Long bookId) {
        return booksRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("book not found"));
    }

    @Override
    public List<BookDto> getBooks() {
        List<BookDto> books = new ArrayList<>();
        booksRepository.findAll().forEach(book -> books.add(new BookDto(book)));
        return books;
    }

    @Override
    public List<BookDto> getBooks(Long catalogId) {
        return booksRepository.getAllByCatalog_Id(catalogId).stream().map(BookDto::new).collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(@NonNull ExtBookDto bookDto) {
        return createOrUpdate(bookDto, getBookById(bookDto.getId()));
    }

    private BookDto createOrUpdate(@NonNull ExtBookDto bookDto, @NonNull Book book) {
        String label = StringUtils.trimToNull(bookDto.getLabel());
        if (label != null)
            book.setLabel(label);

        if (bookDto.getReleaseAt() != null)
            book.setReleaseAt(new Date(bookDto.getReleaseAt()));

        update(bookDto.getAuthorId(), authorService::getAuthorById, book::setAuthor, book.getAuthor());
        update(bookDto.getCatalogId(), catalogService::getCatalogById, book::setCatalog, book.getCatalog());

        return new BookDto(booksRepository.save(book));
    }

    private <E extends BasicEntity> void update(@Nullable Long id, LongFunction<E> getter, @NonNull Consumer<E> setter, E current) {
        if (isNull(id) || nonNull(current) && id.equals(current.getId()))
            return;
        setter.accept(getter.apply(id));
    }

}
