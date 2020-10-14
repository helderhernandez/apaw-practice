package es.upm.miw.apaw_practice.adapters.rest.transport;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.transport.Extra;
import es.upm.miw.apaw_practice.domain.models.transport.ExtraPaidUpdate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


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

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(ExtraResource.EXTRAS + ExtraResource.ID_ID, "kk")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testWorkedHoursbyDepartmentName() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ExtraResource.EXTRAS + ExtraResource.SEARCH)
                                .queryParam("q", "name:name1")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(WorkedHoursExtraDto.class)
                .value(Assertions::assertNotNull)
                .value(WorkedHoursExtraDto -> assertEquals(1, WorkedHoursExtraDto.get(0).getWorkedHours()))
                .value(WorkedHoursExtraDto -> assertEquals(2, WorkedHoursExtraDto.get(1).getWorkedHours()))
                .value(WorkedHoursExtraDto -> assertEquals(3, WorkedHoursExtraDto.get(2).getWorkedHours()))
                .value(WorkedHoursExtraDto -> assertEquals(4, WorkedHoursExtraDto.get(3).getWorkedHours()));
    }

}
