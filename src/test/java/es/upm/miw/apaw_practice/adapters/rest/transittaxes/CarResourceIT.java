package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class CarResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdate() {
        BrandDto brandDto = new BrandDto("CITROEN");
        this.webTestClient
                .put()
                .uri(CarResource.CARS + CarResource.ID_ID + CarResource.BRAND, "01")
                .body(BodyInserters.fromValue(brandDto))
                .exchange()
                .expectStatus().isOk();
    }
}
