package com.example.bookv2.application.DTOs.author;

import jakarta.validation.constraints.NotBlank;

public record CreateAuthorDto(
        @NotBlank(message = "Müəllifin adı boş ola bilməz")
        String name) {
}
