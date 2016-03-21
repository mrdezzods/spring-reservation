package org.neposoft.reservation.controllers;


import domain.AppFacade;
import domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mrdezzods on 28/02/16.
 */
@Controller
public class ReservationsController {


    @Autowired
    AppFacade facade;

    /**
     * @param reservation
     * @param bindingResult
     * @param model         Without this, validation doesn't work
     * @return
     */
    @RequestMapping(value = "/add-reservation/{slug}", method = RequestMethod.POST)
    public ModelAndView put(@Valid Reservation reservation, BindingResult bindingResult, Model model, @PathVariable String slug) {
        ModelAndView mv = new ModelAndView("reservation");

        reservation.setRestaurant(facade.findRestaurantBySlug(slug));

        if (bindingResult.hasErrors()) {
            mv.addObject("errors", bindingResult.getAllErrors());
            mv.addObject("reservation", reservation);
            return mv;
        }

        facade.addReservation(reservation);

        mv.setViewName("redirect:/reservation-success-" + reservation.getId());

        return mv;
    }

    @RequestMapping(value = "/reservations/{slug}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable String slug) {
        ModelAndView mv = new ModelAndView("reservation");
        Reservation reservation = new Reservation();
        reservation.setRestaurant(facade.findRestaurantBySlug(slug));
        mv.addObject("reservation", reservation);
        return mv;
    }

    @RequestMapping(value = "/reservation-success-{id}", method = RequestMethod.GET)
    public ModelAndView reservationSuccess(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView("reservation-success");
        Reservation reservation = facade.getReservation(id);
        mv.addObject("reservation", reservation);

        return mv;
    }


    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        //The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        //Create a new CustomDateEditor
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //Register it as custom editor for the Date type
        binder.registerCustomEditor(Date.class, editor);
    }
}
