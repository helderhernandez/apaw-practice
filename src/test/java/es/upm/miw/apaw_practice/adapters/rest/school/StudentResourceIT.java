package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.models.school.StudentEmailUpdating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class StudentResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(StudentResource.STUDENTS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Student.class)
                .value(Assertions::assertNotNull)
                .hasSize(5);
    }

    @Test
    void testUpdateEmailsNotFound() {
        List<StudentEmailUpdating> studentEmailUpdatingList = Arrays.asList(
                new StudentEmailUpdating("48767689XD", "newemail@gmail.com")
        );
        this.webTestClient
                .patch()
                .uri(StudentResource.STUDENTS)
                .body(BodyInserters.fromValue(studentEmailUpdatingList))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdateEmails() {
        List<StudentEmailUpdating> studentEmailUpdatingList = Arrays.asList(
                new StudentEmailUpdating("48767689X", "newemail@gmail.com"),
                new StudentEmailUpdating("49967689A", "poch@gmail.com")
        );
        this.webTestClient
                .patch()
                .uri(StudentResource.STUDENTS)
                .body(BodyInserters.fromValue(studentEmailUpdatingList))
                .exchange()
                .expectStatus().isOk();
        assertEquals("poch@gmail.com", this.webTestClient
                .get()
                .uri(StudentResource.STUDENTS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Student.class)
                .returnResult()
                .getResponseBody()
                .get(1)
                .getEmail());
    }
}
