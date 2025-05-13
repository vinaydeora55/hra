package reservation_service;



import reservation_entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);
    Optional<Reservation> getReservationById(Long reservationId);
    List<Reservation> getAllReservations();
    Reservation updateReservation(Long reservationId, Reservation reservation);
    void cancelReservation(Long reservationId);
}
