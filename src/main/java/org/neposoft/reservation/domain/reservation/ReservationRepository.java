package org.neposoft.reservation.domain.reservation;

import org.neposoft.reservation.domain.restaurant.Restaurant;

/**
 * Created by mrdezzods on 01/03/16.
 */
public interface ReservationRepository {
    void addReservation(Restaurant restaurantId, Reservation reservation);
    void addReservation(Reservation reservation);
    Reservation get(Integer reservationId);
}
