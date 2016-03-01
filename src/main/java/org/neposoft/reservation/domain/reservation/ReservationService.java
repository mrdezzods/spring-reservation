package org.neposoft.reservation.domain.reservation;

import org.neposoft.reservation.domain.restaurant.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mrdezzods on 01/03/16.
 */
@Service
public class ReservationService {
    @Autowired
    ReservationRepository repository;

    public void addReservation(Restaurant restaurantId, Reservation reservation) {
        repository.addReservation(restaurantId, reservation);
    }

    public Reservation get(Integer reservationId) {
        return repository.get(reservationId);
    }
}
