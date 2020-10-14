package es.upm.miw.apaw_practice.adapters.rest.sportyRental;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.SportyRentalSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.sportyRental.CustomerSportyResource.CUSTOMERS_SPORTY;
import static es.upm.miw.apaw_practice.adapters.rest.sportyRental.CustomerSportyResource.DNI_CUSTOMER;

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
}
