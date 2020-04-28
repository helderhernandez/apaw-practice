package es.upm.miw.apaw_practice.rest.shop;

import es.upm.miw.apaw_practice.data.shop.dtos.TagDto;
import es.upm.miw.apaw_practice.rest.RestTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.rest.shop.TagResource.ID_ID;
import static es.upm.miw.apaw_practice.rest.shop.TagResource.TAGS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
}
