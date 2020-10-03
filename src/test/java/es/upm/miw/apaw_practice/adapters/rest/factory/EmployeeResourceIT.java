package es.upm.miw.apaw_practice.adapters.rest.factory;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.factory.Employee;
import es.upm.miw.apaw_practice.domain.models.factory.EmployeeCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class EmployeeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        EmployeeCreation employeeCreation =
                new EmployeeCreation("55555555F", "Paula", "Calvo", 666666665L,
                        new BigDecimal("24000"), "Sales");
        this.webTestClient
                .post()
                .uri(EmployeeResource.EMPLOYEES)
                .body(BodyInserters.fromValue(employeeCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Employee.class)
                .value(Assertions::assertNotNull)
                .value(employeeData -> assertNotNull(employeeData.getId()));
    }
}
