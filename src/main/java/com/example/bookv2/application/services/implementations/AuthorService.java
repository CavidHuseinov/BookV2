package com.example.bookv2.application.services.implementations;

import com.example.bookv2.application.DTOs.author.AuthorDto;
import com.example.bookv2.application.DTOs.author.CreateAuthorDto;
import com.example.bookv2.application.DTOs.author.UpdateAuthorDto;
import com.example.bookv2.application.services.interfaces.IAuthorService;
import com.example.bookv2.domain.entities.Author;
import com.example.bookv2.persistance.IRepository.IAuthorRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService implements IAuthorService {
    private final IAuthorRepository authorRepo;

    public AuthorService(IAuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorRepo.findAll()
                .stream()
                .map(author -> new AuthorDto(
                    author.getId(),
                    author.getName()
                )).toList();
    }

    @Override
    public AuthorDto getById(int id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(()->new RuntimeException("not found" + id));
        return new AuthorDto(
                author.getId(),
                author.getName()
        );
    }

    @Override
    public void createAuthor(CreateAuthorDto dto) {
        Author newAuthor = new Author();
        newAuthor.setName(dto.name());
        authorRepo.save(newAuthor);
    }

    @Override
    public AuthorDto updateAuthor(UpdateAuthorDto dto) {
        Author author = authorRepo.findById(dto.id())
                .orElseThrow(()-> new RuntimeException("not found" + dto.id()));
        author.setName(dto.name());
        authorRepo.save(author);
        return new AuthorDto(
                author.getId(),
                author.getName()
        );
    }

    @Override
    public void deleteAuthor(int id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Silmək mümkün olmadı. " + id));

        authorRepo.delete(author);
    }
}
