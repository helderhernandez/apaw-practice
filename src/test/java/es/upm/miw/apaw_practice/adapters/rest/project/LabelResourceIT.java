package es.upm.miw.apaw_practice.adapters.rest.project;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.project.Label;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class LabelResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        Label label = new Label("new label", "new description");
        this.webTestClient
                .post()
                .uri(LabelResource.LABEL)
                .body(BodyInserters.fromValue(label))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Label.class)
                .value(Assertions::assertNotNull)
                .value(labelData -> assertNotNull(labelData.getId()));
    }

}
