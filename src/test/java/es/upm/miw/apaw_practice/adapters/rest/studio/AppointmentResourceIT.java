package es.upm.miw.apaw_practice.adapters.rest.studio;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class AppointmentResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(AppointmentResource.APPOINTMENT + AppointmentResource.ID, "kk")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateIsActiveFlags() {
        this.webTestClient
                .patch()
                .uri(AppointmentResource.APPOINTMENT)
                .body(BodyInserters.fromValue(false))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testGetIdsAppointmentByTattoistName() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(AppointmentResource.APPOINTMENT + AppointmentResource.SEARCH)
                        .queryParam("q","name:Doru Ma")
                        .build())
                .exchange()
                .expectStatus().isOk();
    }

}
