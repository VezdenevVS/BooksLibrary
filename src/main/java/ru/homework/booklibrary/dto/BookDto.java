package ru.homework.booklibrary.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.homework.booklibrary.dao.entities.Book;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookDto extends EntityDto<Book> {

    private String label;
    private Long releaseAt;
    private String author;
    private String catalog;

    public BookDto(Book book) {
        super(book);
        setLabel(book.getLabel());
        setReleaseAt(book.getReleaseAt().getTime());
        setAuthor(book.getAuthor().getName());
        setCatalog(book.getCatalog().getLabel());
    }
}
