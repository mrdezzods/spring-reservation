package org.neposoft.reservation.domain.reservation;


public class ReservationService {
    ReservationRepository repository = new ReservationSQLRepository();


    public void addReservation(Reservation reservation){
        repository.addReservation(reservation);
    }

    public Reservation get(Integer reservationId) {
        return repository.get(reservationId);
    }
}
