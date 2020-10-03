package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.school.Teacher;
import es.upm.miw.apaw_practice.domain.models.school.TeacherCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class TeacherResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        TeacherCreation teacherCreation =
                new TeacherCreation("Luisa", "Fridgerard", true, "3365558R", "luisa@gmail.com");
        this.webTestClient
                .post()
                .uri(TeacherResource.TEACHERS)
                .body(BodyInserters.fromValue(teacherCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Teacher.class)
                .value(Assertions::assertNotNull)
                .value(teacherData -> assertNotNull(teacherData.getId()));
    }

    @Test
    void testCreateConflict() {
        TeacherCreation teacherCreation =
                new TeacherCreation("Luisa2", "Fridgerard2", true, "33667788R", "luisa2@gmail.com");
        this.webTestClient
                .post()
                .uri(TeacherResource.TEACHERS)
                .body(BodyInserters.fromValue(teacherCreation))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

}
