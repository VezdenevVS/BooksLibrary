package ru.homework.booklibrary.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.homework.booklibrary.dao.entities.Catalog;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CatalogDto extends EntityDto<Catalog> {

    private String label;

    public CatalogDto(Catalog entity) {
        super(entity);
        setLabel(entity.getLabel());
    }
}
