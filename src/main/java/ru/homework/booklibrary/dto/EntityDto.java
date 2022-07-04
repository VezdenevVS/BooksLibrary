package ru.homework.booklibrary.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.homework.booklibrary.dao.entities.BasicEntity;

import java.util.Objects;

@NoArgsConstructor
@Data
public class EntityDto<E extends BasicEntity> {

    private String id;

    public EntityDto(E entity) {
        Objects.requireNonNull(entity);
        setId(String.valueOf(entity.getId()));
    }

}
