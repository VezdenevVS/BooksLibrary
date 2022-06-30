package ru.homework.booklibrary.dao.repositories;

import org.springframework.stereotype.Repository;
import ru.homework.booklibrary.dao.entities.Book;

import java.util.Set;

@Repository
public interface BooksRepository extends BasicRepository<Book> {

    Set<Book> getAllByCatalog_Id(Long catalogId);

}
