package es.upm.miw.apaw_practice.adapters.rest.sportyrental;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.SportyRentalSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.sportyrental.CustomerSportyResource.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class CustomerSportyResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private SportyRentalSeederService sportyRentalSeederService;

    @AfterEach
    void resetDatabase() {
        sportyRentalSeederService.deleteAll();
        sportyRentalSeederService.seedDatabase();
    }

    @Test
    void testDeleteByDni() {

        this.webTestClient
                .delete()
                .uri(CUSTOMERS_SPORTY + DNI_CUSTOMER, "50206090J")
                .exchange()
                .expectStatus().isOk();

    }

    @Test
    void testDescriptionsCategoryByCustomerName() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(CUSTOMERS_SPORTY + SEARCH_CATEGORY_DESCRIPTIONS)
                                .queryParam("q", "name:Pedro")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(Assertions::assertNotNull)
                .value(String -> assertEquals("[[\"Basket\",\"Football 7\"]]", String.toString()));
    }
}
