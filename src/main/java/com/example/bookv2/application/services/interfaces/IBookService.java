package com.example.bookv2.application.services.interfaces;

import com.example.bookv2.application.DTOs.book.bookDto;
import com.example.bookv2.application.DTOs.book.createBookDto;
import com.example.bookv2.application.DTOs.book.updateBookDto;
import com.example.bookv2.domain.entities.Book;

import java.util.List;

public interface IBookService {
    List<bookDto> getAllBooks();
    bookDto getBookById(int id);
    void createBook (createBookDto book);
    bookDto updateBook(int id, updateBookDto book);
    void deleteBook(int id);
}