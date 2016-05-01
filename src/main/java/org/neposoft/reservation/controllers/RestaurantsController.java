package org.neposoft.reservation.controllers;


import domain.AppFacade;
import domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

/**
 * Created by mrdezzods on 28/02/16.
 */
@Controller
public class RestaurantsController {


    @Autowired
    AppFacade facade;

    @RequestMapping(value = "/restaurants")
    @ResponseBody
    public Set<Restaurant> paginate() {
        return facade.getAllRestaurants();
    }



}
