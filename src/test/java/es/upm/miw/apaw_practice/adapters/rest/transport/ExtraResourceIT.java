package es.upm.miw.apaw_practice.adapters.rest.transport;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.school.StudentEmailUpdating;
import es.upm.miw.apaw_practice.domain.models.transport.Extra;
import es.upm.miw.apaw_practice.domain.models.transport.ExtraPaidUpdate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@RestTestConfig
public class ExtraResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdatePaids() {
        List<ExtraPaidUpdate> extraPaidUpdate = Arrays.asList(
                new ExtraPaidUpdate("1", false),
                new ExtraPaidUpdate("2", true)
        );
        this.webTestClient
                .patch()
                .uri(ExtraResource.EXTRAS)
                .body(BodyInserters.fromValue(extraPaidUpdate))
                .exchange()
                .expectStatus().isOk();
        assertFalse(Objects.requireNonNull(this.webTestClient
                .get()
                .uri(ExtraResource.EXTRAS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Extra.class)
                .returnResult()
                .getResponseBody())
                .get(0)
                .getPaid());
    }

}
