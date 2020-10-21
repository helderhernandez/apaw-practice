package es.upm.miw.apaw_practice.adapters.rest.project;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.project.Issue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class IssueResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(IssueResource.ISSUE)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Issue.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testFindDevelopersEmailByLabelName() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(IssueResource.ISSUE + IssueResource.SEARCH)
                                .queryParam("q", "labelName:documentation")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(Assertions::assertNotNull);
    }

}
