package mylab.order.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
    @Autowired
    ShoppingCart cart;

    @Autowired
    OrderService service;

    @Test
    void testShoppingCart() {
        assertNotNull(cart);
        assertEquals(30000, cart.getTotalPrice());

        for (Product product : cart.getProducts()) {
            System.out.println(product.getName());
        }
    }

    @Test
    void testOrderService() {
        assertNotNull(service);
        assertEquals(30000, service.calculateOrderTotal());
        System.out.println(service.calculateOrderTotal());
    }
}
