package com.example.bookv2.application.DTOs.author;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateAuthorDto(
        @NotNull(message = "Id daxil edin")
        int id,
        @NotBlank(message = "Muellifin adini daxil edin")
        String name) {
}
