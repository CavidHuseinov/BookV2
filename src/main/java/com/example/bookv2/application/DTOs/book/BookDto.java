package com.example.bookv2.application.DTOs.book;

import java.math.BigDecimal;

public record BookDto(int id, String name, String description , BigDecimal price) { }
