package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.Coach;
import es.upm.miw.apaw_practice.domain.models.basketball.CoachCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class CoachResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        CoachCreation coachCreation = new CoachCreation("Jacinto", "44444444N");
        this.webTestClient
                .post()
                .uri(CoachResource.COACHS)
                .body(BodyInserters.fromValue(coachCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Coach.class)
                .value(Assertions::assertNotNull)
                .value(coach -> assertNotNull(coach.getId()));
    }

    @Test
    void testUpdateName() {
        CoachCreation coachCreation = new CoachCreation("Coach Lucas", "2222222A");
        this.webTestClient
                .patch()
                .uri(CoachResource.COACHS)
                .body(BodyInserters.fromValue(coachCreation))
                .exchange()
                .expectStatus()
                .isOk();
    }
}
