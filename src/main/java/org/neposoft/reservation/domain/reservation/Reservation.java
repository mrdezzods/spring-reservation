package org.neposoft.reservation.domain.reservation;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonProperty;
import org.neposoft.reservation.domain.client.Client;
import org.neposoft.reservation.domain.restaurant.Restaurant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    @JsonProperty(value = "Client")
    private Client client;

    private int people;

    @Column(name = "reservation_for")
    private Date reservationFor;

    private String note;

    @Column(name = "status")
    private ReservationStatus status;

    public int getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Client getClient() {
        return client;
    }

    public int getPeople() {
        return people;
    }

    public Date getReservationFor() {
        return reservationFor;
    }

    public String getNote() {
        return note;
    }

    public ReservationStatus getStatus() {
        return status;
    }

}