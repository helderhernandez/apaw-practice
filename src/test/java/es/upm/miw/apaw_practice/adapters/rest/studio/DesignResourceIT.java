package es.upm.miw.apaw_practice.adapters.rest.studio;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.studio.Design;
import es.upm.miw.apaw_practice.domain.models.studio.DesignCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class DesignResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        DesignCreation designCreation = new DesignCreation(
                "single",
                Boolean.FALSE,
                new BigDecimal("450.00"),
                "Japanese Traditional"
        );
        this.webTestClient
                .post()
                .uri(DesignResource.DESIGN)
                .body(BodyInserters.fromValue(designCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Design.class)
                .value(Assertions::assertNotNull)
                .value(design -> assertNotNull(design.getId()));
    }

    @Test
    void testFindCustomersByType() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(DesignResource.DESIGN + DesignResource.SEARCH)
                        .queryParam("q","type:collaborative")
                        .build())
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void findDesignStylesByUserPhone() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(DesignResource.DESIGN + DesignResource.PHONE)
                        .queryParam("q","phone:123456789")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class);
    }

}
