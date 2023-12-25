package edu.bbte.bibliospring.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.bbte.bibliospring.model.dto.ReservationCompleteDTO;
import edu.bbte.bibliospring.model.entity.Reservation;

@Component
public class ReservationDTOMapper {

    @Autowired
    private UserDTOMapper userDTOMapper;

    @Autowired
    private BookDTOMapper bookDTOMapper;

    public ReservationCompleteDTO modelToComplete(Reservation reservation) {
        ReservationCompleteDTO reservationCompleteDTO = new ReservationCompleteDTO();
        reservationCompleteDTO.setId(reservation.getId());
        reservationCompleteDTO.setUser(userDTOMapper.modelToMinimal(reservation.getUser()));
        reservationCompleteDTO.setBook(bookDTOMapper.modelToMinimal(reservation.getBook()));
        return reservationCompleteDTO;
    }

    public Reservation completeToModel(ReservationCompleteDTO reservationCompleteDTO) {
        Reservation reservation = new Reservation();
        reservation.setUser(userDTOMapper.minimalToModel(reservationCompleteDTO.getUser()));
        reservation.setBook(bookDTOMapper.minimalToModel(reservationCompleteDTO.getBook()));
        return reservation;
    }

}
