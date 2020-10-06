package es.upm.miw.apaw_practice.adapters.rest.project;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class DeveloperResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateYearsOfExperience() {
        this.webTestClient
                .put()
                .uri(DeveloperResource.DEVELOPER + DeveloperResource.ID_ID + DeveloperResource.YEARS_OF_EXPERIENCE, "")
                .body(BodyInserters.fromValue(10))
                .exchange()
                .expectStatus().isNotFound();
    }

}
