package org.neposoft.reservation.controllers;


import domain.AppFacade;
import domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
     * @return
     */
    @RequestMapping(value = "/reservations/{slug}", method = RequestMethod.POST)
    public ModelAndView put(@Valid Reservation reservation, BindingResult bindingResult, @PathVariable String slug) {
        reservation.setRestaurant(facade.findRestaurantBySlug(slug));
        ModelAndView mv = new ModelAndView("reservation", "command", reservation);

        mv.addObject("reviews", facade.getReviewsFromWebservice(reservation.getRestaurant().getSlug()));

        if (bindingResult.hasErrors()) {
            mv.addObject("errors", bindingResult.getAllErrors());
            return mv;
        }

        facade.addReservation(reservation);

        mv.setViewName("redirect:/reservation-success-" + reservation.getId());

        return mv;
    }


    @RequestMapping(value = "/reservations/{slug}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable String slug) {

        Reservation reservation = new Reservation();
        reservation.setRestaurant(facade.findRestaurantBySlug(slug));
        ModelAndView mv = new ModelAndView("reservation", "command", reservation);
        mv.addObject("reviews", facade.getReviewsFromWebservice(reservation.getRestaurant().getSlug()));
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


    @RequestMapping(value = "/reservations-admin", method = RequestMethod.GET)
    public ModelAndView reservationsAdmin(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("reservations-admin");
        if (session.getAttribute("user") == null) {
            //   modelAndView.setViewName("redirect:/login");
        }

        modelAndView.addObject("reservations", facade.getAllReservations());
        return modelAndView;
    }

    @RequestMapping(value = "/delete-reservation", method = RequestMethod.POST)
    public ModelAndView deleteReservation(@RequestParam("reservation_id") Integer reservationId) {
        ModelAndView modelAndView = new ModelAndView();
        facade.deleteReservation(reservationId);
        modelAndView.setViewName("redirect:/reservations-admin");

        return modelAndView;
    }

    @RequestMapping(value = "/accept-reservation", method = RequestMethod.POST)
    public ModelAndView acceptReservation(@RequestParam("reservation_id") Integer reservationId) {
        ModelAndView modelAndView = new ModelAndView();
        facade.acceptReservation(reservationId);
        modelAndView.setViewName("redirect:/reservations-admin");

        return modelAndView;
    }
}
