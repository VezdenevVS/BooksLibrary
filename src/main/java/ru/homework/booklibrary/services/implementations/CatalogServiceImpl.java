package ru.homework.booklibrary.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.homework.booklibrary.dao.entities.Catalog;
import ru.homework.booklibrary.dao.repositories.CatalogsRepository;
import ru.homework.booklibrary.dto.CatalogDto;
import ru.homework.booklibrary.services.interfaces.CatalogService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogsRepository catalogsRepository;

    @Override
    public List<CatalogDto> getCatalogs() {
        List<CatalogDto> catalogs = new ArrayList<>();
        catalogsRepository.findAll().forEach(catalog -> catalogs.add(new CatalogDto(catalog)));
        return catalogs;
    }

    @Override
    public Catalog getCatalogById(Long catalogId) {
        return catalogsRepository.findById(catalogId).orElseThrow(() -> new EntityNotFoundException("catalog not found"));
    }
}
