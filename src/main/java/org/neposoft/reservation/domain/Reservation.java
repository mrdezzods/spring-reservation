package org.neposoft.reservation.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    private int id;
}
