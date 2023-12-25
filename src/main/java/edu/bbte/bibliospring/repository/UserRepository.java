package edu.bbte.bibliospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.bbte.bibliospring.model.entity.User;

/**
 * CRUD operations for user entities.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u where u.username=?1")
    User findByUsername(String username);

    List<User> findAll();

    void deleteUserById(Long id);

    void deleteUserByUsername(String username);

}
