package ru.homework.booklibrary.dto;

import lombok.*;
import ru.homework.booklibrary.dao.entities.Book;

@NoArgsConstructor
@NonNull
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ExtBookDto extends BookDto {

    private Long authorId;
    private Long catalogId;

    public ExtBookDto(Book book) {
        super(book);
        if (book.getAuthor() != null)
            setAuthorId(book.getAuthor().getId());
        if (book.getCatalog() != null)
            setAuthorId(book.getCatalog().getId());
    }
}
