package es.upm.miw.apaw_practice.adapters.rest.race;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.race.Runner;
import es.upm.miw.apaw_practice.domain.models.race.RunnerProfessionalUpdating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class RunnerResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(RunnerResource.RUNNERS + RunnerResource.ID_ID, "2")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Runner.class)
                .value(Assertions::assertNotNull)
                .value(runner -> {
                    assertEquals("Maria", runner.getName());
                    assertTrue(runner.getProfessional());
                    assertEquals("Madrid", runner.getRunnerClub().getLocation());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(RunnerResource.RUNNERS + RunnerResource.ID_ID, "-1")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testPatch() {
        List<RunnerProfessionalUpdating> runnerProfessionalUpdatings = Arrays.asList(
                new RunnerProfessionalUpdating("00000003", Boolean.TRUE),
                new RunnerProfessionalUpdating("00000004", Boolean.TRUE)
        );

        this.webTestClient
                .patch()
                .uri(RunnerResource.RUNNERS)
                .body(BodyInserters.fromValue(runnerProfessionalUpdatings))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testPatchNotFound() {
        List<RunnerProfessionalUpdating> runnerProfessionalUpdatings = Arrays.asList(
                new RunnerProfessionalUpdating("-1", Boolean.TRUE)
        );

        this.webTestClient
                .patch()
                .uri(RunnerResource.RUNNERS)
                .body(BodyInserters.fromValue(runnerProfessionalUpdatings))
                .exchange()
                .expectStatus().isNotFound();
    }
}
