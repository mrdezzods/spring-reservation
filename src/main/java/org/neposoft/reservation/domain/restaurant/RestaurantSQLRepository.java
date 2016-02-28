package org.neposoft.reservation.domain.restaurant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
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
    public List<Restaurant> paginate(Pageable pageable) {
        return getSession().createQuery("from Restaurant")
                .setMaxResults(4)
                .list();
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }


}
