package es.upm.miw.apaw_practice.rest.shop;

import es.upm.miw.apaw_practice.data.shop.dtos.ArticleItemDto;
import es.upm.miw.apaw_practice.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static es.upm.miw.apaw_practice.rest.shop.ShoppingCartResource.*;

@RestTestConfig
class ShoppingCartResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Test
    void testUpdate() {
        List<ArticleItemDto> articleItemArray = Arrays.asList(
                new ArticleItemDto(84002L, 2, BigDecimal.ONE),
                new ArticleItemDto(84003L, 3, BigDecimal.TEN)
        );
        this.webTestClient
                .put()
                .uri(this.contextPath + SHOPPING_CARTS + ID_ID + ARTICLE_ITEMS, "kk")
                .body(BodyInserters.fromValue(articleItemArray))
                .exchange()
                .expectStatus().isNotFound();
    }
}
