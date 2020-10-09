package es.upm.miw.apaw_practice.adapters.rest.sportcentre;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.sportcentre.DurationsUpdating;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Speciality;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                .value(Assertions::assertNotNull);
    }

    @Test
    void updateDurationsNotFound(){
        List<DurationsUpdating> durationsList = Arrays.asList(new DurationsUpdating("spec8",90));
        this.webTestClient
                .patch()
                .uri(SpecialityResource.SPECIALITIES)
                .body(BodyInserters.fromValue(durationsList))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void updateDurations(){
        List<DurationsUpdating> durationsList = Arrays.asList(
                new DurationsUpdating("spec1",90),
                new DurationsUpdating("spec2",80));
        this.webTestClient
                .patch()
                .uri(SpecialityResource.SPECIALITIES)
                .body(BodyInserters.fromValue(durationsList))
                .exchange()
                .expectStatus().isOk();
        assertEquals(80,
                this.webTestClient
                    .get()
                    .uri(SpecialityResource.SPECIALITIES)
                    .exchange()
                    .expectStatus().isOk()
                    .expectBodyList(Speciality.class)
                    .returnResult()
                    .getResponseBody()
                    .get(1)
                    .getDuration());
    }

}
