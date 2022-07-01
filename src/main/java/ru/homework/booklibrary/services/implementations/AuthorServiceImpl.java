package ru.homework.booklibrary.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.homework.booklibrary.dao.entities.Author;
import ru.homework.booklibrary.dao.repositories.AuthorsRepository;
import ru.homework.booklibrary.services.interfaces.AuthorService;

import javax.persistence.EntityNotFoundException;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorsRepository authorsRepository;

    @Override
    public Author getAuthorById(Long authorId) {
        return authorsRepository.findById(authorId).orElseThrow(() -> new EntityNotFoundException("author not found"));
    }
}
