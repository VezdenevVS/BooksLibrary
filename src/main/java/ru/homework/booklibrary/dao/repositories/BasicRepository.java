package ru.homework.booklibrary.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.homework.booklibrary.dao.entities.BasicEntity;

@NoRepositoryBean
public interface BasicRepository<T extends BasicEntity> extends CrudRepository<T, Long> {
}
