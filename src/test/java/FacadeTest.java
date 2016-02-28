import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neposoft.reservation.AppConfig;
import org.neposoft.reservation.domain.AppFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by mrdezzods on 28/02/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class FacadeTest extends TestCase {

    @Autowired
    AppFacade facade;

    @Test
    public void test_if_facade_returns_restaurants() {
        assertNotNull(facade.popularRestaurants());
    }
}
