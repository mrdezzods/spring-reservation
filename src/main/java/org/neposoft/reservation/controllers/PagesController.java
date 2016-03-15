/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.neposoft.reservation.controllers;

import org.neposoft.reservation.domain.AppFacade;
import org.neposoft.reservation.domain.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mrdezzods
 */
@Controller
public class PagesController {


    @Autowired
    private RestaurantService service;

    @Autowired
    private AppFacade facade;

    @RequestMapping(value = "/")
    public ModelAndView homepage() {
        ModelAndView mv = new ModelAndView("homepage");
        mv.addObject("popularRestaurants", facade.getAllRestaurants());
        return mv;
    }

    @RequestMapping(value = "/contact")
    public String contact() {
        return "contact";
    }
}
