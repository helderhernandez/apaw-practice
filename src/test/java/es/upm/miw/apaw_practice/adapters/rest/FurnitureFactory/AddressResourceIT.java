package es.upm.miw.apaw_practice.adapters.rest.FurnitureFactory;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;


@RestTestConfig
public class AddressResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(AddressResource.ADDRESS + AddressResource.ID_ID, "kk")
                .exchange()
                .expectStatus().isOk();
    }

}
