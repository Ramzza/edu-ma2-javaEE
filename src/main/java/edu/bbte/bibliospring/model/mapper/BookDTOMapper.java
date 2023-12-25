package edu.bbte.bibliospring.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.bbte.bibliospring.model.dto.AuthorCompleteDTO;
import edu.bbte.bibliospring.model.dto.BookCompleteDTO;
import edu.bbte.bibliospring.model.dto.BookMinimalDTO;
import edu.bbte.bibliospring.model.entity.Author;
import edu.bbte.bibliospring.model.entity.Book;

@Component
public class BookDTOMapper {

    @Autowired
    private AuthorDTOMapper authorDTOMapper;

    public BookCompleteDTO modelToComplete(Book book) {
        BookCompleteDTO bookCompleteDTO = new BookCompleteDTO();
        bookCompleteDTO.setId(book.getId());
        bookCompleteDTO.setTitle(book.getTitle());
        bookCompleteDTO.setIsbn(book.getIsbn());
        bookCompleteDTO.setPublishingDate(book.getPublishingDate());
        bookCompleteDTO.setType(book.getType());

        List<AuthorCompleteDTO> authors = new ArrayList<>();
        book.getAuthors().stream().forEach(author -> authors.add(authorDTOMapper.modelToComplete(author)));
        bookCompleteDTO.setAuthors(authors);

        return bookCompleteDTO;
    }

    public Book completeToModel(BookCompleteDTO bookCompleteDTO) {
        Book book = new Book();
        book.setTitle(bookCompleteDTO.getTitle());
        book.setIsbn(bookCompleteDTO.getIsbn());
        book.setPublishingDate(bookCompleteDTO.getPublishingDate());
        book.setType(bookCompleteDTO.getType());

        List<Author> authors = new ArrayList<>();
        bookCompleteDTO.getAuthors().stream().forEach(author -> authors.add(authorDTOMapper.completeToModel(author)));
        book.setAuthors(authors);

        return book;
    }

    public BookMinimalDTO modelToMinimal(Book book) {
        BookMinimalDTO bookMinimalDTO = new BookMinimalDTO();
        bookMinimalDTO.setId(book.getId());
        bookMinimalDTO.setTitle(book.getTitle());

        List<AuthorCompleteDTO> authors = new ArrayList<>();
        book.getAuthors().stream().forEach(author -> authors.add(authorDTOMapper.modelToComplete(author)));
        bookMinimalDTO.setAuthors(authors);

        return bookMinimalDTO;
    }

    public Book minimalToModel(BookMinimalDTO bookMinimalDTO) {
        Book book = new Book();
        book.setTitle(bookMinimalDTO.getTitle());

        List<Author> authors = new ArrayList<>();
        bookMinimalDTO.getAuthors().stream().forEach(author -> authors.add(authorDTOMapper.completeToModel(author)));
        book.setAuthors(authors);

        return book;
    }

    public List<Author> completeAuthorsToModel(List<AuthorCompleteDTO> authorCompleteDTOs) {

        List<Author> authors = new ArrayList<>();
        authorCompleteDTOs.stream().forEach(author -> authors.add(authorDTOMapper.completeToModel(author)));

        return authors;
    }

}
