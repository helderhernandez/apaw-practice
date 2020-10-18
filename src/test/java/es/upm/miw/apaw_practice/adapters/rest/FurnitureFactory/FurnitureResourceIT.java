package es.upm.miw.apaw_practice.adapters.rest.FurnitureFactory;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Furniture;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.FurnitureItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class FurnitureResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(FurnitureResource.FURNITURE)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Furniture.class)
                .value(Assertions::assertNotNull)
                .hasSize(4);
    }
    @Test
    void testUpdateNotFound() {
        FurnitureItem furnitureName = new FurnitureItem("sofa");
        this.webTestClient
                .put()
                .uri(FurnitureResource.FURNITURE + FurnitureResource.ID_ID + FurnitureResource.NAME, "kkk")
                .body(BodyInserters.fromValue(furnitureName))
                .exchange()
                .expectStatus().isNotFound();
    }
    @Test
    void testFindTotalPriceFurnitureByStreet() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(FurnitureResource.FURNITURE + FurnitureResource.SEARCH)
                                .queryParam("q", "street:Granvia")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BigDecimal.class)
                .value(furniture -> assertEquals(new BigDecimal("885.20"), furniture.get(0)));
    }
}
