package com.example.bookv2.application.services.interfaces;

import com.example.bookv2.application.DTOs.book.BookDto;
import com.example.bookv2.application.DTOs.book.CreateBookDto;
import com.example.bookv2.application.DTOs.book.UpdateBookDto;

import java.util.List;

public interface IBookService {
    List<BookDto> getAllBooks();
    BookDto getBookById(int id);
    void createBook (CreateBookDto book);
    BookDto updateBook(int id, UpdateBookDto book);
    void deleteBook(int id);
}