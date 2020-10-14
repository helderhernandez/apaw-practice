package es.upm.miw.apaw_practice.adapters.rest.treeConservation;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.treeConservation.Disease;
import es.upm.miw.apaw_practice.domain.models.treeConservation.DiseaseCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class DiseaseResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        DiseaseCreation diseaseCreation =
                new DiseaseCreation("diseaseResourceTest", "This is a resource test disease");
        this.webTestClient
                .post()
                .uri(DiseaseResource.DISEASES)
                .body(BodyInserters.fromValue(diseaseCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Disease.class)
                .value(Assertions::assertNotNull)
                .value(disease -> assertNotNull(disease.getId()));
    }
}
