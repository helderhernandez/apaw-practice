package es.upm.miw.apaw_practice.business.rest.shop;

import es.upm.miw.apaw_practice.business.rest.RestTestConfig;
import es.upm.miw.apaw_practice.data.model.dtos.shop.ArticleItemDto;
import es.upm.miw.apaw_practice.data.model.dtos.shop.ShoppingCartReferenceDto;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static es.upm.miw.apaw_practice.business.rest.shop.ShoppingCartResource.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testFindByPriceGreaterThan() {
        Matcher<String> x;
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(this.contextPath + SHOPPING_CARTS + SEARCH)
                                .queryParam("q", "price:5.0")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ShoppingCartReferenceDto.class)
                .value(shoppingCartReferenceDtoList -> shoppingCartReferenceDtoList.get(0).getUser(), equalTo("user2"))
                .value(shoppingCartReferenceDtoList -> assertTrue(shoppingCartReferenceDtoList.size() > 0));
    }
}
