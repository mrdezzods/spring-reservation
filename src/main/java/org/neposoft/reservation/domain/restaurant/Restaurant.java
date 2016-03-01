package org.neposoft.reservation.domain.restaurant;


import org.codehaus.jackson.annotate.JsonManagedReference;
import org.neposoft.reservation.domain.reservation.Reservation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Entity

@Table(name = "restaurants")
public class Restaurant implements Serializable {

    @Id
    private Integer id;

    private String slug;

    private String name;

    private String logo;

    private String address;

    @Column(name = "reservation_opens_at")
    private String reservationOpensAt;

    @Column(name = "reservation_closes_at")
    private String reservationClosesAt;

    @Column(name = "max_reservations")
    private int maxReservations;

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference
    private List<Reservation> reservations;

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        if (this.reservations == null) {
            this.reservations = new ArrayList<>();
        }
        this.reservations.add(reservation);
    }

    //  private List<Reservation> reservationList;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getLogo() {
        return logo;
    }

    public String getAddress() {
        return address;
    }

    public String getReservationOpensAt() {
        return reservationOpensAt;
    }

    public String getReservationClosesAt() {
        return reservationClosesAt;
    }

    public int getMaxReservations() {
        return maxReservations;
    }


}
