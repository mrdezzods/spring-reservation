package org.neposoft.reservation.domain.reservation;

import org.neposoft.reservation.domain.DomainException;
import org.neposoft.reservation.domain.restaurant.Restaurant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class ReservationSQLRepository implements ReservationRepository {

    private EntityManagerFactory factory;
    private EntityManager manager;

    public void openConnection() {
        factory = Persistence.createEntityManagerFactory("reservation");
        manager = factory.createEntityManager();
    }

    public void closeConnection() {
        try {
            manager.close();
            factory.close();
        } catch (Exception e) {
            throw new DomainException(e.getMessage(), e);
        }
    }

    @Override
    public void addReservation(Restaurant restaurant, Reservation reservation) {
        restaurant.addReservation(reservation);
    }

    @Override
    public void addReservation(Reservation reservation) {

    }

    @Override
    public Reservation get(Integer reservationId) {
        return null;
    }

}
