package es.upm.miw.apaw_practice.adapters.rest.FurnitureFactory;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class StaffResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        Staff staffCreation =
                new Staff("Yicheng", "Pan", 23, 688151524, "director","Y6587108C");
        this.webTestClient
                .post()
                .uri(StaffResource.STAFF)
                .body(BodyInserters.fromValue(staffCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Staff.class)
                .value(Assertions::assertNotNull)
                .value(workerData -> assertNotNull(workerData.getId()));
    }

    @Test
    void testCreateConflict() {
        Staff staffCreation =
                new Staff("German", "Dolado", 19, 657011258, "director","Y6577008A");
        this.webTestClient
                .post()
                .uri(StaffResource.STAFF)
                .body(BodyInserters.fromValue(staffCreation))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
