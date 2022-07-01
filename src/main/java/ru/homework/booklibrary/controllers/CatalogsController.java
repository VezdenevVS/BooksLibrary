package ru.homework.booklibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.homework.booklibrary.dto.CatalogDto;
import ru.homework.booklibrary.services.interfaces.CatalogService;

import java.util.List;

@RestController
@RequestMapping("/catalog/")
public class CatalogsController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("all")
    public List<CatalogDto> getCatalogs() {
        return catalogService.getCatalogs();
    }

}
