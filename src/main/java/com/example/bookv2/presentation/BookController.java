package com.example.bookv2.presentation;

import com.example.bookv2.application.DTOs.book.BookDto;
import com.example.bookv2.application.DTOs.book.CreateBookDto;
import com.example.bookv2.application.DTOs.book.UpdateBookDto;
import com.example.bookv2.application.services.interfaces.IBookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final IBookService iBookService;

    public BookController(IBookService iBookService) {
        this.iBookService = iBookService;
    }
    @GetMapping
    public List<BookDto> FindAll(){
        return iBookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public BookDto FindById(@PathVariable int id){
        return iBookService.getBookById(id);
    }
    @PostMapping
    public void Create(@Valid @RequestBody CreateBookDto dto){
        iBookService.createBook(dto);
    }
    @PutMapping("/{id}")
    public BookDto Update(@Valid @RequestBody UpdateBookDto dto,@PathVariable int id){
       return iBookService.updateBook(id, dto);
    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id){
        iBookService.deleteBook(id);
    }
}
