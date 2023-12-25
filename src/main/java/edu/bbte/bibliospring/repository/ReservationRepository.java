package edu.bbte.bibliospring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.bbte.bibliospring.model.entity.Reservation;

/**
 * CRUD operations for reservation entities.
 */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findAll();

    void deleteReservationById(Long id);

}
