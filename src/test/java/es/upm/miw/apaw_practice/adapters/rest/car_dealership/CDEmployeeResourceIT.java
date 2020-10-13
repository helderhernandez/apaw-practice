package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import static es.upm.miw.apaw_practice.adapters.rest.car_dealership.CDEmployeeResource.ID_ID;
import static es.upm.miw.apaw_practice.adapters.rest.car_dealership.CDEmployeeResource.EMPLOYEES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class CDEmployeeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(EMPLOYEES + ID_ID, "e2301")
                .exchange()
                .expectStatus().isOk();
    }
}
