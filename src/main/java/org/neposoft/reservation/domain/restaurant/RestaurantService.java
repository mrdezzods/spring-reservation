package org.neposoft.reservation.domain.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mrdezzods on 27/02/16.
 */
@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository repository;

    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    public List<Restaurant> paginate(Pageable pageable) {

        return repository.paginate(pageable);
    }
}
