package org.neposoft.reservation.domain.reservation;

import org.neposoft.reservation.domain.DomainException;
import org.neposoft.reservation.domain.restaurant.Restaurant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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
    public void addReservation(Reservation reservation) {
        EntityTransaction tx = null;
        try {
            openConnection();
            tx = manager.getTransaction();
            tx.begin();
            manager.persist(reservation);
            tx.commit();
        } catch (Exception ex) {
            throw new DomainException(ex.getMessage(), ex);
        } finally {
            tx.rollback();
            closeConnection();
        }
    }

    @Override
    public Reservation get(Integer reservationId) {
        try {
            openConnection();
            Reservation r = (Reservation) manager.createQuery("select r from Reservation r where r.id = :id")
                    .setParameter("id", reservationId)
                    .getSingleResult();

            return r;
        } catch (Exception ex) {
            throw new DomainException(ex.getMessage(), ex);
        } finally {
            closeConnection();
        }
    }

}
