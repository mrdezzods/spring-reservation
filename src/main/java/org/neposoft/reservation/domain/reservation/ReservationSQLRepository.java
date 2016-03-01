package org.neposoft.reservation.domain.reservation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.neposoft.reservation.domain.restaurant.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by mrdezzods on 01/03/16.
 */
@Repository
public class ReservationSQLRepository implements ReservationRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addReservation(Restaurant restaurant, Reservation reservation) {
        restaurant.addReservation(reservation);
    }

    @Override
    public Reservation get(Integer reservationId) {
        return null;
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }
}
