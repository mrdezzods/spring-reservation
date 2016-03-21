package org.neposoft.reservation.domain.reservation;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonProperty;
import org.neposoft.reservation.domain.client.Client;
import org.neposoft.reservation.domain.restaurant.Restaurant;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    @JsonProperty(value = "Client")
    private Client client;

    @NotNull(message = "validation.reservation.people.notnull")
    @Max(value = 10, message = "validation.reservation.people.max")
    @Min(value = 1, message = "validation.reservation.people.min")
    private int people = 2;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public void setPeople(int people) {
        this.people = people;
    }

    public void setReservationFor(Date reservationFor) {
        this.reservationFor = reservationFor;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
