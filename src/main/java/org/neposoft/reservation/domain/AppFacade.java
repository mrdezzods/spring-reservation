package org.neposoft.reservation.domain;

import org.neposoft.reservation.domain.reservation.Reservation;
import org.neposoft.reservation.domain.reservation.ReservationService;
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

    @Autowired
    public ReservationService reservationService;

    public AppFacade() {
    }


    public List<Restaurant> popularRestaurants() {
        return restaurantService.getAll();
    }

    public void addReservation(Integer restaurantId, Reservation reservation) {
        reservationService.addReservation(restaurantService.findById(restaurantId), reservation);
    }

    public Restaurant findRestaurantBySlug(String slug) {
        return restaurantService.findBySlug(slug);
    }

    public void addReservationWithSlug(String slug, Reservation reservation) {
        reservationService.addReservation(restaurantService.findBySlug(slug), reservation);
    }

    public Reservation getReservation(Integer reservationId) {
        return reservationService.get(reservationId);
    }
}
