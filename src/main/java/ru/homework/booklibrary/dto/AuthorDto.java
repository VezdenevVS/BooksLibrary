package ru.homework.booklibrary.dto;

import lombok.*;
import ru.homework.booklibrary.dao.entities.Author;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AuthorDto extends EntityDto<Author> {

    private String name;

    public AuthorDto(Author entity) {
        super(entity);
        setName(entity.getName());
    }
}
