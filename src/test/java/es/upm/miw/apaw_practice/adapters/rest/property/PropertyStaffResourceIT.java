package es.upm.miw.apaw_practice.adapters.rest.property;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.property.PropertyStaff;
import es.upm.miw.apaw_practice.domain.models.property.PropertyStaffCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class PropertyStaffResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        PropertyStaffCreation propertyStaffCreation =
                new PropertyStaffCreation("Mario","59230573A","Tuesday on duty");
        this.webTestClient
                .post()
                .uri(PropertyStaffResource.STAFFS)
                .body(BodyInserters.fromValue(propertyStaffCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(PropertyStaff.class)
                .value(Assertions::assertNotNull)
                .value(staff -> assertNotNull(staff.getId()));
    }
}