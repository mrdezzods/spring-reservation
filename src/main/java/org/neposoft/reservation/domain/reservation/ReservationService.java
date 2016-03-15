package org.neposoft.reservation.domain.reservation;

import org.neposoft.reservation.domain.restaurant.Restaurant;

/**
 * Created by mrdezzods on 01/03/16.
 */

public class ReservationService {
    ReservationRepository repository = new ReservationSQLRepository();

    public void addReservation(Restaurant restaurantId, Reservation reservation) {
        repository.addReservation(restaurantId, reservation);
    }

    public void addReservation(Reservation reservation){
        repository.addReservation(reservation);
    }

    public Reservation get(Integer reservationId) {
        return repository.get(reservationId);
    }
}
