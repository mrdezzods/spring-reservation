package org.neposoft.reservation.domain.restaurant;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mrdezzods on 29/02/16.
 */
@Repository
public class RestaurantFakeRepository implements RestaurantRepository {
    @Override
    public List<Restaurant> getAll() {
        return null;
    }

    @Override
    public void delete(Restaurant restaurant) {

    }

    @Override
    public void add(Restaurant restaurant) {

    }


    @Override
    public Restaurant findBySlug(String slug) {
        return null;
    }

    @Override
    public Restaurant findById(Integer restaurantId) {
        return null;
    }
}
