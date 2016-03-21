package org.neposoft.reservation.domain.restaurant;

import org.neposoft.reservation.domain.DomainException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Repository
@Primary
public class RestaurantSQLRepository implements RestaurantRepository {


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


    public List<Restaurant> getAll() {
        openConnection();
        List results = manager.createQuery("from Restaurant").getResultList();
        return (List<Restaurant>) results;

    }

    @Override
    public void delete(Restaurant restaurant) {

    }

    @Override
    public void add(Restaurant restaurant) {

    }


    @Override
    public Restaurant findBySlug(String slug) {
        try {
            openConnection();
            Restaurant r = (Restaurant) manager.createQuery("select r from Restaurant r where r.slug = :slug")
                    .setParameter("slug", slug)
                    .getSingleResult();

            if (r == null) {
                throw new DomainException("Restaurant not found");
            }
            return r;
        } catch (Exception ex) {
            throw new DomainException(ex.getMessage(), ex);
        } finally {
            closeConnection();
        }

    }

    @Override
    public Restaurant findById(Integer restaurantId) {
        try {
            openConnection();
            Restaurant r = (Restaurant) manager.createQuery("select r from Restaurant r where r.id = :id")
                    .setParameter("id", restaurantId)
                    .getSingleResult();

            return r;
        } catch (Exception ex) {
            throw new DomainException(ex.getMessage(), ex);
        } finally {
            closeConnection();
        }
    }


}
