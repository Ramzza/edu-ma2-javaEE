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

import edu.bbte.bibliospring.model.entity.Reservation;
import edu.bbte.bibliospring.model.dto.ReservationCompleteDTO;
import edu.bbte.bibliospring.model.mapper.ReservationDTOMapper;
import edu.bbte.bibliospring.repository.ReservationRepository;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationDTOMapper reservationDTOMapper;
    @Autowired
    private ReservationRepository repository;

    ReservationController() {
    }

    @GetMapping
    List<ReservationCompleteDTO> all() {
        List<ReservationCompleteDTO> reservations = new ArrayList<>();
        repository.findAll().stream().forEach(
                (Reservation reservation) -> reservations.add(reservationDTOMapper.modelToComplete(reservation)));
        return reservations;
    }

    @PostMapping
    ReservationCompleteDTO createReservation(@RequestBody ReservationCompleteDTO newReservation) {
        return reservationDTOMapper
                .modelToComplete(repository.save(reservationDTOMapper.completeToModel(newReservation)));
    }

    @GetMapping("/{id}")
    ReservationCompleteDTO one(@PathVariable Long id) {
        return reservationDTOMapper.modelToComplete(repository.findById(id).orElse(null));
    }

    @DeleteMapping("/{id}")
    void deleteReservation(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
