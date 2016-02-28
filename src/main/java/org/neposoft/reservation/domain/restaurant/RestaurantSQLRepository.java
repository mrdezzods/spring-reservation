package org.neposoft.reservation.domain.restaurant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    private Session getSession() {
        return sessionFactory.openSession();
    }


}
