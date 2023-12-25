package edu.bbte.bibliospring.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.bbte.bibliospring.model.entity.Author;

/**
 * CRUD operations for author entities.
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findAll();

    void deleteAuthorById(Long id);
}
