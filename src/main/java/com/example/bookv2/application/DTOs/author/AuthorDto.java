package com.example.bookv2.application.DTOs.author;

import com.example.bookv2.application.DTOs.book.BookDto;
import com.example.bookv2.domain.entities.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public record AuthorDto(int id,
                        String name,
                        @JsonIgnoreProperties("author")
                        List<BookDto> books) {
}
