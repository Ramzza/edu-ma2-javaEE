package edu.bbte.bibliospring.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bbte.bibliospring.model.entity.Author;
import edu.bbte.bibliospring.model.dto.AuthorCompleteDTO;
import edu.bbte.bibliospring.model.mapper.AuthorDTOMapper;
import edu.bbte.bibliospring.repository.AuthorRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorDTOMapper authorDTOMapper;
    @Autowired
    private AuthorRepository repository;

    AuthorController() {
    }

    @GetMapping
    List<AuthorCompleteDTO> all() {
        List<AuthorCompleteDTO> authors = new ArrayList<>();
        repository.findAll().stream().forEach((Author author) -> authors.add(authorDTOMapper.modelToComplete(author)));
        return authors;
    }

    @PostMapping
    AuthorCompleteDTO createAuthor(@RequestBody AuthorCompleteDTO newAuthor) {
        return authorDTOMapper.modelToComplete(repository.save(authorDTOMapper.completeToModel(newAuthor)));
    }

    @GetMapping("/{id}")
    AuthorCompleteDTO one(@PathVariable Long id) {
        return authorDTOMapper.modelToComplete(repository.findById(id).orElse(null));
    }

    @DeleteMapping("/{id}")
    void deleteAuthor(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
