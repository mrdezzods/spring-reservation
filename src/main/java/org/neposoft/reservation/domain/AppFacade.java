package org.neposoft.reservation.domain;

import org.neposoft.reservation.domain.restaurant.Restaurant;
import org.neposoft.reservation.domain.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by mrdezzods on 28/02/16.
 */
public class AppFacade {

    @Autowired
    private RestaurantService restaurantService;

    public AppFacade() {
    }


    public List<Restaurant> popularRestaurants() {
        return restaurantService.getAll();
    }

}
