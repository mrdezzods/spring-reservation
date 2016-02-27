/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neposoft.reservation.controllers;

import org.neposoft.reservation.domain.restaurant.Restaurant;
import org.neposoft.reservation.domain.restaurant.RestaurantSQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author mrdezzods
 */
@Controller
public class PagesController {


    @Autowired
    private RestaurantSQLRepository service;

    @RequestMapping(value = "/")
    @ResponseBody
    public ModelAndView homepage() {
        ModelAndView mv = new ModelAndView("restaurants");
        List<Restaurant> restaurants = service.getAll();
        mv.addObject("restaurants", restaurants);

        return mv;
    }

    @RequestMapping(value = "/contact")

    public String contact() {
        return "contact";
    }
}
