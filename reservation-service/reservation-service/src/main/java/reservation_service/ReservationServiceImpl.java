package reservation_service;


import reservation_entity.Reservation;
import reservation_repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        reservation.setStatus("BOOKED");
        return reservationRepository.save(reservation);
    }

    @Override
    public Optional<Reservation> getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Long reservationId, Reservation updatedReservation) {
        return reservationRepository.findById(reservationId)
                .map(reservation -> {
                    reservation.setSeatNumber(updatedReservation.getSeatNumber());
                    reservation.setTravelDate(updatedReservation.getTravelDate());
                    reservation.setStatus(updatedReservation.getStatus());
                    return reservationRepository.save(reservation);
                })
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    @Override
    public void cancelReservation(Long reservationId) {
        reservationRepository.findById(reservationId)
                .ifPresent(reservation -> {
                    reservation.setStatus("CANCELLED");
                    reservationRepository.save(reservation);
                });
    }
}
