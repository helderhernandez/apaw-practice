package es.upm.miw.apaw_practice.adapters.rest.FurnitureFactory;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.school.CourseResource;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Staff;
import es.upm.miw.apaw_practice.domain.models.school.Course;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void testFindFirstNameByWarehouseName() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(StaffResource.STAFF + StaffResource.SEARCH)
                        .queryParam("q", "name:b")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Staff.class)
                .value(staff -> assertEquals("Jose", staff.get(0).getFirstName()))
                .value(staff -> assertEquals("German", staff.get(1).getFirstName()))
                .value(staff -> assertEquals("Pablo", staff.get(2).getFirstName()))
                .value(staff -> assertEquals("Sebastian", staff.get(3).getFirstName()));


    }
}
