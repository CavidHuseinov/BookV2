package com.example.bookv2.application.services.implementations;

import com.example.bookv2.application.DTOs.book.bookDto;
import com.example.bookv2.application.DTOs.book.createBookDto;
import com.example.bookv2.application.DTOs.book.updateBookDto;
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
    public List<bookDto> getAllBooks() {
        return bookRepo.findAll()
                .stream()
                .map(book -> new bookDto(
                        book.getName(),
                        book.getDescription(),
                        book.getPrice()
                ))
                .toList();
    }

    @Override
    public bookDto getBookById(int id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        return new bookDto(
                book.getName(),
                book.getDescription(),
                book.getPrice()
        );
    }

    @Override
    public void createBook(createBookDto book) {
        Book newBook = new Book();
        newBook.setName(book.name());
        newBook.setDescription(book.description());
        newBook.setPrice(book.price());
        bookRepo.save(newBook);
    }

    @Override
    public bookDto updateBook(int id, updateBookDto book) {
        Book existingBook = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        existingBook.setName(book.name());
        existingBook.setDescription(book.description());
        existingBook.setPrice(book.price());
        bookRepo.save(existingBook);

        return new bookDto(
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
