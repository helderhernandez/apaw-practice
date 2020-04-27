package es.upm.miw.apaw_practice.data.shop.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ShoppingCartRepositoryIT {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.shoppingCartRepository.findAll().stream()
                .anyMatch(cart -> "user 1".equals(cart.getUser()) &&
                        "address 1".equals(cart.getAddress()) &&
                        2 == cart.getArticleItems().size() &&
                        84001L == cart.getArticleItems().get(0).getArticle().getBarcode() &&
                        1 == cart.getArticleItems().get(0).getAmount() &&
                        0 == BigDecimal.ZERO.compareTo(cart.getArticleItems().get(0).getDiscount())
                ));
    }
}
