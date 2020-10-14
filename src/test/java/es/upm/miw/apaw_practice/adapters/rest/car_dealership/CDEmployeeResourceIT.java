package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDEmployee;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDEmployeeSalaryUpdate;
import org.junit.jupiter.api.Test;
import static es.upm.miw.apaw_practice.adapters.rest.car_dealership.CDEmployeeResource.ID_ID;
import static es.upm.miw.apaw_practice.adapters.rest.car_dealership.CDEmployeeResource.EMPLOYEES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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

    @Test
    void testEmployeeSalariesNotFound() {
        List<CDEmployeeSalaryUpdate> employeeSalaryUpdates = Arrays.asList(
                new CDEmployeeSalaryUpdate("e2300", new BigDecimal("28000")),
                new CDEmployeeSalaryUpdate("e2301", new BigDecimal("30000"))
                );
        this.webTestClient
                .patch()
                .uri(EMPLOYEES)
                .body(BodyInserters.fromValue(employeeSalaryUpdates))
                .exchange()
                .expectStatus().isOk()
                .expectBody(CDEmployee.class);
    }
}
