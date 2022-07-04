package ru.homework.booklibrary.services.implementations;

import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.homework.booklibrary.dao.entities.Author;
import ru.homework.booklibrary.dao.repositories.AuthorsRepository;
import ru.homework.booklibrary.dto.AuthorDto;
import ru.homework.booklibrary.services.interfaces.AuthorService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorsRepository authorsRepository;

    public AuthorDto addAuthor(AuthorDto authorDto) {
        return createOrUpdate(authorDto, new Author());
    }

    @Override
    public AuthorDto getAuthor(Long authorId) {
        return new AuthorDto(getAuthorById(authorId));
    }

    @Override
    public Author getAuthorById(Long authorId) {
        return authorsRepository.findById(authorId).orElseThrow(() -> new EntityNotFoundException("author not found"));
    }

    @Override
    public List<AuthorDto> getAuthors() {
        List<AuthorDto> authors = new ArrayList<>();
        authorsRepository.findAll().forEach(author -> authors.add(new AuthorDto(author)));
        return authors;
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto) {
        Author author = getAuthorById(Long.valueOf(authorDto.getId()));
        return createOrUpdate(authorDto, author);
    }

    private AuthorDto createOrUpdate(AuthorDto authorDto, Author author) {
        String name = StringUtils.trimToNull(authorDto.getName());
        if (name != null)
            author.setName(name);
        return new AuthorDto(authorsRepository.save(author));
    }

}
