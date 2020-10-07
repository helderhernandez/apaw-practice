package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class VehicleResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdate() {
        BrandDto brandDto = new BrandDto("CITROEN");
        this.webTestClient
                .put()
                .uri(VehicleResource.VEHICLES + VehicleResource.ID_ID + VehicleResource.BRAND, "01")
                .body(BodyInserters.fromValue(brandDto))
                .exchange()
                .expectStatus().isOk();
    }
}
