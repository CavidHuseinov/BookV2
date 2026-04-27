package com.example.bookv2.presentation;

import com.example.bookv2.application.DTOs.author.AuthorDto;
import com.example.bookv2.application.DTOs.author.CreateAuthorDto;
import com.example.bookv2.application.DTOs.author.UpdateAuthorDto;
import com.example.bookv2.application.services.interfaces.IAuthorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping()
    public List<AuthorDto> GetAllAuthors(){return authorService.getAllAuthors();}
    @GetMapping("/{id}")
    public AuthorDto GetByIdAuthors(@PathVariable int id){return authorService.getById(id);}
    @PostMapping()
    public void CreateAuthor(@Valid @RequestBody CreateAuthorDto dto){authorService.createAuthor(dto);}
    @PutMapping()
    public AuthorDto UpdateAuthor(@Valid @RequestBody UpdateAuthorDto dto){return authorService.updateAuthor(dto);}
    @DeleteMapping("/{id}")
    public void DeleteAuthorById(@PathVariable int id){authorService.deleteAuthor(id);}
}
