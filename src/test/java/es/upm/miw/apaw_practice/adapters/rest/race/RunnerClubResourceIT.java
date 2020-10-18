package es.upm.miw.apaw_practice.adapters.rest.race;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClub;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClubCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class RunnerClubResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        RunnerClubCreation runnerClubCreation = new RunnerClubCreation("Malaga Runners", "Malaga", LocalDateTime.of(2018, 4, 3, 0, 0));

        webTestClient
                .post()
                .uri(RunnerClubResource.RUNNER_CLUBS)
                .body(BodyInserters.fromValue(runnerClubCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(RunnerClub.class)
                .value(Assertions::assertNotNull)
                .value(runnerClub -> assertNotNull(runnerClub.getId()))
                .value(runnerClub -> assertEquals("Malaga Runners", runnerClub.getName()))
                .value(runnerClub -> assertEquals("Malaga", runnerClub.getLocation()))
                .value(runnerClub -> assertEquals(LocalDateTime.of(2018, 4, 3, 0, 0), runnerClub.getFoundationDate()));
    }

    @Test
    void testFindRunnerClubNameWithProfessionalRunnersByRaceName() {
        webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(RunnerClubResource.RUNNER_CLUBS + RunnerClubResource.SEARCH)
                        .queryParam("q", "race-name:Madrid Running Race")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(names -> {
                    assertTrue(names.contains("Runners Club"));
                    assertFalse(names.contains("Amateur Running Club"));
                });
    }
}
