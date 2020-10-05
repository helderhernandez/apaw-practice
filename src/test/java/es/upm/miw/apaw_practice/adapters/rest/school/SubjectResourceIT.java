package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.school.SubjectItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

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
}
