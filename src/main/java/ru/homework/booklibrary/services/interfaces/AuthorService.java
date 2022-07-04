package ru.homework.booklibrary.services.interfaces;

import org.springframework.stereotype.Service;
import ru.homework.booklibrary.dao.entities.Author;
import ru.homework.booklibrary.dto.AuthorDto;

import java.util.List;

@Service
public interface AuthorService {

    AuthorDto addAuthor(AuthorDto authorDto);

    AuthorDto getAuthor(Long authorId);

    Author getAuthorById(Long authorId);

    List<AuthorDto> getAuthors();

    AuthorDto updateAuthor(AuthorDto authorDto);

}
