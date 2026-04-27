package com.example.bookv2.application.DTOs.book;

import com.example.bookv2.application.DTOs.author.AuthorDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

public record BookDto(int id,
                      String name,
                      String description ,
                      BigDecimal price ,
                      @JsonIgnoreProperties("books")
                      AuthorDto author) { }
