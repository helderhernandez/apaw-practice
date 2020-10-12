package es.upm.miw.apaw_practice.adapters.rest.transport;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
class DepartmentResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateNotFound() {
        UbicationDto ubicationDto = new UbicationDto();
        ubicationDto.setUbication("newUbication");

        this.webTestClient
                .put()
                .uri(DepartmentResource.DEPARTMENTS + DepartmentResource.NAME_NAME + DepartmentResource.UBICATION, "kkk")
                .body(BodyInserters.fromValue(ubicationDto))
                .exchange()
                .expectStatus().isNotFound();
    }
}
