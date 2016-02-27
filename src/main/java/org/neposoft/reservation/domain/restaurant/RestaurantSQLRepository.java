package org.neposoft.reservation.domain.restaurant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Repository
public class RestaurantSQLRepository {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Restaurant> getAll() {
        Session session = sessionFactory.openSession();
        return (List<Restaurant>) session.createQuery("from Restaurant")
                .list();

    }


}
