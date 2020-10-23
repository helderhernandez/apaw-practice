package es.upm.miw.apaw_practice.adapters.rest.article;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class WorksResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete(){
        this.webTestClient
                .delete()
                .uri(WorksResource.WORKSES + WorksResource.ID_ID,"kk")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void findAllIsmPriceMoreThanTen(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(WorksResource.WORKSES + WorksResource.SEARCH)
                                .queryParam("q","name:Comedy")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BigDecimal.class)
                .value(works -> assertEquals(new BigDecimal("55.95"),works.get(0)));
    }
}