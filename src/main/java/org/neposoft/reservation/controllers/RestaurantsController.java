package org.neposoft.reservation.controllers;


import domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import services.RestaurantService;

import java.util.List;

/**
 * Created by mrdezzods on 28/02/16.
 */
@Controller
public class RestaurantsController {

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value = "/restaurants")
    @ResponseBody
    public List<Restaurant> paginate() {
        List<Restaurant> restaurants = restaurantService.getAll();
        System.out.println(restaurants.get(0).getReservations().get(0).getClient().getName());
        return restaurants;
    }



}
