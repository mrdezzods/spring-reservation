package org.neposoft.reservation.domain.restaurant;


import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Entity
@JsonSerialize
public class Restaurant implements Serializable {

    @Id
    private Integer id;

    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String toString() {
        return name;
    }

}
