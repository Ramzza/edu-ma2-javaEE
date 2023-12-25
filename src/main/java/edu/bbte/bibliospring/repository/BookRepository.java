package edu.bbte.bibliospring.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.bbte.bibliospring.model.entity.Book;

/**
 * CRUD operations for book entities.
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();

    void deleteBookById(Long id);
}
