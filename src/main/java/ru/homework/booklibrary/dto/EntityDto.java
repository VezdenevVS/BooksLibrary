package ru.homework.booklibrary.dto;

import lombok.Data;
import ru.homework.booklibrary.dao.entities.BasicEntity;

import java.util.Objects;

@Data
public class EntityDto<E extends BasicEntity> {

    private Long id;

    public EntityDto(E entity) {
        Objects.requireNonNull(entity);
        setId(entity.getId());
    }

}
