package org.neposoft.reservation.domain;

import org.neposoft.reservation.domain.reservation.Reservation;
import org.neposoft.reservation.domain.reservation.ReservationService;
import org.neposoft.reservation.domain.restaurant.Restaurant;
import org.neposoft.reservation.domain.restaurant.RestaurantService;

import java.util.List;

/**
 * Created by mrdezzods on 28/02/16.
 */
public class AppFacade {

    private RestaurantService restaurantService;

    public ReservationService reservationService;

    public AppFacade(Env env){

    }
    public AppFacade() {
        reservationService = new ReservationService();
        restaurantService = new RestaurantService();
    }


    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAll();
    }


    public void addReservation(Reservation reservation) {
        reservationService.addReservation(reservation);
    }

    public Restaurant findRestaurantBySlug(String slug) {
        return restaurantService.findBySlug(slug);
    }

    public Reservation getReservation(Integer reservationId) {
        return reservationService.get(reservationId);
    }

    public Restaurant findRestaurantById(int i) {
        return restaurantService.findById(i);
    }
}
