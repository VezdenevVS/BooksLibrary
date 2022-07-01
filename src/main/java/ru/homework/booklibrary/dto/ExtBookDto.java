package ru.homework.booklibrary.dto;

import lombok.*;
import ru.homework.booklibrary.dao.entities.Book;

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
    }
}
