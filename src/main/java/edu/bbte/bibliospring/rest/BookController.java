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

import edu.bbte.bibliospring.model.entity.Book;
import edu.bbte.bibliospring.model.dto.BookCompleteDTO;
import edu.bbte.bibliospring.model.mapper.BookDTOMapper;
import edu.bbte.bibliospring.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookDTOMapper bookDTOMapper;
    @Autowired
    private BookRepository repository;

    BookController() {
    }

    @GetMapping
    List<BookCompleteDTO> all() {
        List<BookCompleteDTO> books = new ArrayList<>();
        repository.findAll().stream().forEach((Book book) -> books.add(bookDTOMapper.modelToComplete(book)));
        return books;
    }

    @PostMapping
    BookCompleteDTO createBook(@RequestBody BookCompleteDTO newBook) {
        return bookDTOMapper.modelToComplete(repository.save(bookDTOMapper.completeToModel(newBook)));
    }

    @GetMapping("/{id}")
    BookCompleteDTO one(@PathVariable Long id) {
        return bookDTOMapper.modelToComplete(repository.findById(id).orElse(null));
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
