package ru.homework.booklibrary.services.interfaces;

import org.springframework.stereotype.Service;
import ru.homework.booklibrary.dao.entities.Author;

@Service
public interface AuthorService {

    Author getAuthorById(Long authorId);

}
