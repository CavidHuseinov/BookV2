package com.example.bookv2.application.services.implementations;

import com.example.bookv2.application.DTOs.book.BookDto;
import com.example.bookv2.application.DTOs.book.CreateBookDto;
import com.example.bookv2.application.DTOs.book.UpdateBookDto;
import com.example.bookv2.application.services.interfaces.IBookService;
import com.example.bookv2.domain.entities.Book;
import com.example.bookv2.persistance.IRepository.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    private final IBookRepository bookRepo;

    public BookService(IBookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepo.findAll()
                .stream()
                .map(book -> new BookDto(
                        book.getId(),
                        book.getName(),
                        book.getDescription(),
                        book.getPrice()
                ))
                .toList();
    }

    @Override
    public BookDto getBookById(int id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        return new BookDto(
                book.getId(),
                book.getName(),
                book.getDescription(),
                book.getPrice()
        );
    }

    @Override
    public void createBook(CreateBookDto book) {
        Book newBook = new Book();
        newBook.setName(book.name());
        newBook.setDescription(book.description());
        newBook.setPrice(book.price());
        bookRepo.save(newBook);
    }

    @Override
    public BookDto updateBook(int id, UpdateBookDto book) {
        Book existingBook = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        existingBook.setName(book.name());
        existingBook.setDescription(book.description());
        existingBook.setPrice(book.price());
        bookRepo.save(existingBook);

        return new BookDto(
                existingBook.getId(),
                existingBook.getName(),
                existingBook.getDescription(),
                existingBook.getPrice()
        );
    }

    @Override
    public void deleteBook(int id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        bookRepo.delete(book);
    }


}
