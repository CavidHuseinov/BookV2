package com.example.bookv2.application.DTOs.book;

import jakarta.validation.constraints.*;

public record updateBookDto(
        @NotBlank(message = "Kitabin adini teyin edin")
        @Size(min = 1 , max= 30, message = "kitabin adi 1-30 simvol " +
                "arasi teyin olunmalidir")
        String name,
        @NotBlank(message = "kitab haqqinda aciqlama teyin edin")
        @Size(min=3 , message = "kitab haqqinda aciqlama minimum 3simvoldan" +
                " ibaret olmalidir.")
        String description ,
        @NotNull(message = "Kitaba qiymet teyin edin zehmet olmasa")
        @Min(value = 0.1 , message = "Kitab ucun qiymet minimum 0.1-dir.")
        @Max(value = 500, message = "Kitab ucun teyin ede bileceyiniz maksimal qiymet 500-dur")
        int price) {}
