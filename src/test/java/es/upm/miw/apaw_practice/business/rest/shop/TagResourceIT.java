package es.upm.miw.apaw_practice.business.rest.shop;

import es.upm.miw.apaw_practice.business.rest.RestTestConfig;
import es.upm.miw.apaw_practice.data.model.dtos.shop.TagDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static es.upm.miw.apaw_practice.business.rest.shop.TagResource.*;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class TagResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(this.contextPath + TAGS + ID_ID, "tag3")
                .exchange()
                .expectStatus().isOk()
                .expectBody(TagDto.class)
                .value(Assertions::assertNotNull)
                .value(tagData -> {
                    assertEquals("tag 3", tagData.getDescription());
                    assertEquals(1, tagData.getArticlesBarcode().size());
                    assertEquals(84002L, tagData.getArticlesBarcode().get(0));
                    assertFalse(tagData.getFavourite());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(this.contextPath + TAGS + ID_ID, "kk")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(this.contextPath + TAGS + ID_ID, "kk")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testFindByArticlesInShoppingCarts() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(this.contextPath + TAGS + SEARCH)
                        .queryParam("q", "shopping-carts:in")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(TagDto.class)
                .consumeWith(entityList -> {
                    assertNotNull(entityList.getResponseBody());
                    List<String> tagList = entityList.getResponseBody().stream()
                            .map(TagDto::getId)
                            .collect(Collectors.toList());
                    assertTrue(tagList.containsAll(Arrays.asList("tag1", "tag2", "tag3")));
                    assertFalse(tagList.contains("tag4"));
                });
    }

    @Test
    void testFindByArticlesInShoppingCartsBadRequest() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(this.contextPath + TAGS + SEARCH)
                                .queryParam("q", "shopping-carts:kk")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }
}
