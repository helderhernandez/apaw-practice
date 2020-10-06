package es.upm.miw.apaw_practice.adapters.rest.factory;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.factory.DegreeResource.DEGREES;
import static es.upm.miw.apaw_practice.adapters.rest.factory.DegreeResource.ID_ID;

@RestTestConfig
public class DegreeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(DEGREES + ID_ID, "notAnId")
                .exchange()
                .expectStatus().isOk();
    }
}
