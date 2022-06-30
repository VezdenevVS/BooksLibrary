package ru.homework.booklibrary.services.interfaces;

import ru.homework.booklibrary.dao.entities.Catalog;
import ru.homework.booklibrary.dto.CatalogDto;

import java.util.List;

public interface CatalogService {

    List<CatalogDto> getCatalogs();

    Catalog getCatalogById(Long catalogId);
}
