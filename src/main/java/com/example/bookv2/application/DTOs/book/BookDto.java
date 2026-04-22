package com.example.bookv2.application.DTOs.book;

import java.math.BigDecimal;

public record BookDto(String name, String description , BigDecimal price) { }
