import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.neposoft.reservation.domain.AppFacade;
import org.neposoft.reservation.domain.DomainException;
import org.neposoft.reservation.domain.restaurant.Restaurant;

import java.util.List;

/**
 * Created by mrdezzods on 28/02/16.
 */

public class FacadeTest extends TestCase {

    AppFacade facade;

    @Before
    public void setUp() {
        facade = new AppFacade();
    }

    @Test
    public void test_if_facade_returns_restaurants() {
        List restaurants = facade.getAllRestaurants();
        assertNotNull(restaurants);
    }

    @Test
    public void test_if_facade_returns_restaurant_by_slug() {
        Restaurant r = facade.findRestaurantBySlug("nepali-house");
        assertNotNull(r);
    }

    @Test(expected = Exception.class)
    public void test_if_null_slug_throws_exception() {
        Restaurant r = facade.findRestaurantBySlug(null);
    }


    @Test(expected = DomainException.class)
    public void test_if_invalid_id_throws_exception() {
        Restaurant r = facade.findRestaurantById(-22);
    }


}
