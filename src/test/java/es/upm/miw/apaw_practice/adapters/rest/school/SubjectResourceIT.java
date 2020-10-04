package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import es.upm.miw.apaw_practice.domain.models.school.SubjectItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class SubjectResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateNotFound() {
        SubjectItem subjectName = new SubjectItem("Computer sciences");
        this.webTestClient
                .put()
                .uri(SubjectResource.SUBJECTS + SubjectResource.ID_ID + SubjectResource.NAME, "kkk")
                .body(BodyInserters.fromValue(subjectName))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdate() {
        Subject subject = this.webTestClient
                .get()
                .uri(SubjectResource.SUBJECTS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Subject.class)
                .value(Assertions::assertNotNull)
                .returnResult()
                .getResponseBody()
                .get(0);
        SubjectItem subjectName = new SubjectItem("Computer sciences");
        this.webTestClient
                .put()
                .uri(SubjectResource.SUBJECTS + SubjectResource.ID_ID + SubjectResource.NAME, subject.getId())
                .body(BodyInserters.fromValue(subjectName))
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Subject.class)
                .value(Assertions::assertNotNull);
        assertEquals("Computer sciences", this.webTestClient
                .get()
                .uri(SubjectResource.SUBJECTS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Subject.class)
                .returnResult()
                .getResponseBody()
                .get(0)
                .getName());
    }
}
