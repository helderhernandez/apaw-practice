package es.upm.miw.apaw_practice.adapters.rest.sportcentre;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Speciality;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class SpecialityResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void readAll(){
        this.webTestClient
                .get()
                .uri(SpecialityResource.SPECIALITIES)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Speciality.class)
                .value(Assertions::assertNotNull)
                .hasSize(5);
    }

}
