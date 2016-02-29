package org.neposoft.reservation.domain.client;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.neposoft.reservation.domain.reservation.Reservation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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

    @NotEmpty
    private String name;

    @Email
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
