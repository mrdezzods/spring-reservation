package org.neposoft.reservation.controllers;

import org.neposoft.reservation.domain.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by mrdezzods on 28/02/16.
 */
@RestController
@EnableWebMvc
public class RestaurantsController {

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Object paginate() {
        PageRequest pageRequest = new PageRequest(1,5);
        return restaurantService.paginate(pageRequest);
    }
}
