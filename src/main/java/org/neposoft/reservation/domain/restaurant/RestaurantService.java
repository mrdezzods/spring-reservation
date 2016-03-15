package org.neposoft.reservation.domain.restaurant;

import org.neposoft.reservation.domain.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Service
public class RestaurantService {

    // @Autowired
    RestaurantRepository repository = new RestaurantSQLRepository();

    public List<Restaurant> getAll() {
        return repository.getAll();
    }


    public Restaurant findBySlug(String slug) {
        if (slug == null || slug.isEmpty()) {
            throw new DomainException("Slug cannot be empty");
        }
        return repository.findBySlug(slug);
    }

    public Restaurant findById(Integer restaurantId) {
        return repository.findById(restaurantId);
    }
}
