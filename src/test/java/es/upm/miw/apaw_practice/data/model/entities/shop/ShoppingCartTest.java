package es.upm.miw.apaw_practice.data.model.entities.shop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

    @Test
    void testTotal() {
        Article[] articles = {
                new Article(84001L, "art 001", new BigDecimal("1.23"), "prov 1"),
                new Article(84002L, "art 002", new BigDecimal("0.27"), "prov 2"),
                new Article(84003L, "art 003", new BigDecimal("12.13"), "prov 3")
        };
        ArticleItem[] articleItems = {
                new ArticleItem(articles[0], 1, BigDecimal.ZERO),
                new ArticleItem(articles[1], 2, BigDecimal.TEN),
                new ArticleItem(articles[2], 3, new BigDecimal("20.5"))
        };
        BigDecimal total = new ShoppingCart(Arrays.asList(articleItems[0], articleItems[1], articleItems[2]),
                "user1", "address 1").total();
        assertEquals(0, new BigDecimal("30.64605").compareTo(total));
    }
}
