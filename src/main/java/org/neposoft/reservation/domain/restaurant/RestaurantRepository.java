package org.neposoft.reservation.domain.restaurant;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Created by mrdezzods on 27/02/16.
 */
@NoRepositoryBean
public interface RestaurantRepository {

    List<Restaurant> getAll();

    void delete(Restaurant restaurant);

    void add(Restaurant restaurant);


    Restaurant findBySlug(String slug);

    Restaurant findById(Integer restaurantId);
}
