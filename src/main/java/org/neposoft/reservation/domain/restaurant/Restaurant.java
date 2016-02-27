package org.neposoft.reservation.domain.restaurant;


import javax.persistence.*;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Entity
public class Restaurant {

    @Id
    private Integer id;

    private String name;

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

}
