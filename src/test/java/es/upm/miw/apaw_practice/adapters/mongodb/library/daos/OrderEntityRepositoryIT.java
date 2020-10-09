package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;
@TestConfig
public class OrderEntityRepositoryIT {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testCreateAndRead(){
        assertTrue(this.orderRepository.findAll().stream()
                .anyMatch(order ->
                        "1".equals(order.getId())&&
                                order.getCreationTime()!=null&&
                                order.getPaymentTime()!=null&&
                                order.getReturnTime()!=null&&
                                new BigDecimal(12.3).equals(order.getRental())));
    }
}
