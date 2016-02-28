package org.neposoft.reservation.domain.client;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.neposoft.reservation.domain.reservation.Reservation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    private int id;

    private String name;

    private String email;

    private String tel;

    @OneToMany(mappedBy = "client")
    @JsonManagedReference
    private List<Reservation> reservations;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
