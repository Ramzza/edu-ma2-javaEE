package edu.bbte.bibliospring.model.mapper;

import org.springframework.stereotype.Component;

import edu.bbte.bibliospring.model.dto.AuthorCompleteDTO;
import edu.bbte.bibliospring.model.entity.Author;

@Component
public class AuthorDTOMapper {

    public AuthorCompleteDTO modelToComplete(Author author) {
        AuthorCompleteDTO authorCompleteDTO = new AuthorCompleteDTO();
        authorCompleteDTO.setId(author.getId());
        authorCompleteDTO.setFirstName(author.getFirstName());
        authorCompleteDTO.setLastName(author.getLastName());
        return authorCompleteDTO;
    }

    public Author completeToModel(AuthorCompleteDTO authorCompleteDTO) {
        Author author = new Author();
        author.setFirstName(authorCompleteDTO.getFirstName());
        author.setLastName(authorCompleteDTO.getLastName());
        return author;
    }

}
