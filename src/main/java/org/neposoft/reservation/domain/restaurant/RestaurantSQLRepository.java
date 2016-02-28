package org.neposoft.reservation.domain.restaurant;

import javassist.NotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.neposoft.reservation.domain.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Repository
@Primary
public class RestaurantSQLRepository implements RestaurantRepository {

    @Autowired

    private SessionFactory sessionFactory;


    public List<Restaurant> getAll() {
        return (List<Restaurant>) getSession().createQuery("from Restaurant")
                .list();

    }

    @Override
    public void delete(Restaurant restaurant) {

    }

    @Override
    public void add(Restaurant restaurant) {

    }

    @Override
    public List<Restaurant> paginate() {
        return getSession().createQuery("from Restaurant")
                .list();
    }

    @Override
    public Restaurant findBySlug(String slug) {
        List<Restaurant> restaurants = getSession().createQuery("from Restaurant where  slug = :slug")
                .setParameter("slug", slug)
                .setMaxResults(1)
                .list();

        if (restaurants.size() == 0) {
            throw new DomainException("Restaurant not found!");
        }

        return restaurants.get(0);
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }


}
