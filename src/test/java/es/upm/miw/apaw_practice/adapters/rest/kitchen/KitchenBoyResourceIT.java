package es.upm.miw.apaw_practice.adapters.rest.kitchen;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.KitchenSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.kitchen.KitchenBoyResource.DNI;
import static es.upm.miw.apaw_practice.adapters.rest.kitchen.KitchenBoyResource.KITCHEN_BOY;

@RestTestConfig
class KitchenBoyResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private KitchenSeederService kitchenSeederService;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(KITCHEN_BOY + DNI, "12345678A")
                .exchange()
                .expectStatus().isOk();

        this.kitchenSeederService.deleteAll();
        this.kitchenSeederService.seedDatabase();
    }
}
