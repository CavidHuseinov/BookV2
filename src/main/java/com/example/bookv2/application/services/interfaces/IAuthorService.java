package com.example.bookv2.application.services.interfaces;

import com.example.bookv2.application.DTOs.author.AuthorDto;
import com.example.bookv2.application.DTOs.author.CreateAuthorDto;
import com.example.bookv2.application.DTOs.author.UpdateAuthorDto;

import java.util.List;

public interface IAuthorService {
    List<AuthorDto> getAllAuthors();
    AuthorDto getById(int id);
    void createAuthor(CreateAuthorDto dto);
    AuthorDto updateAuthor(UpdateAuthorDto dto);
    void deleteAuthor(int id);
}
