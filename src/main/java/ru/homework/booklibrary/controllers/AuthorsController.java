package ru.homework.booklibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.homework.booklibrary.dto.AuthorDto;
import ru.homework.booklibrary.services.interfaces.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/author/")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("add")
    public AuthorDto addAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.addAuthor(authorDto);
    }

    @GetMapping("{authorId}")
    public AuthorDto getAuthor(@PathVariable Long authorId) {
        return authorService.getAuthor(authorId);
    }

    @GetMapping("all")
    public List<AuthorDto> getAuthors() {
        return authorService.getAuthors();
    }

    @PutMapping("{authorId}")
    public AuthorDto updateAuthor(@PathVariable String authorId, @RequestBody AuthorDto authorDto) {
        authorDto.setId(authorId);
        return authorService.updateAuthor(authorDto);
    }


}
