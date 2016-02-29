package org.neposoft.reservation.controllers;

import org.neposoft.reservation.domain.reservation.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by mrdezzods on 28/02/16.
 */
@Controller
public class ReservationsController {


    @RequestMapping(value = "/reservations")
    public ModelAndView put(@Valid Reservation reservation, BindingResult bindingResult, Model model) {
        ModelAndView mv = new ModelAndView("reservation");
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors().toString());

            mv.addObject("errors", bindingResult.getAllErrors());
        }


        mv.addObject("reservation", reservation);
        return mv;
    }
}
