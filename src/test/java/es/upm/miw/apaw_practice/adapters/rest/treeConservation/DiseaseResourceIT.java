package es.upm.miw.apaw_practice.adapters.rest.treeConservation;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.treeConservation.Disease;
import es.upm.miw.apaw_practice.domain.models.treeConservation.DiseaseCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static es.upm.miw.apaw_practice.adapters.rest.treeConservation.DiseaseResource.*;
import static org.junit.jupiter.api.Assertions.*;

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
                .uri(DISEASES)
                .body(BodyInserters.fromValue(diseaseCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Disease.class)
                .value(Assertions::assertNotNull)
                .value(disease -> assertNotNull(disease.getId()));
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(DISEASES + NAME_ID, "fakeDiseaseResourceTest")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testFindByInspectionType() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(DISEASES + SEARCH)
                        .queryParam("q", "type:type1")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(DiseaseNameDto.class)
                .consumeWith(entityList -> {
                    assertNotNull(entityList.getResponseBody());
                    List<String> specieList = entityList.getResponseBody().stream()
                            .map(DiseaseNameDto::getName)
                            .collect(Collectors.toList());
                    assertTrue(specieList.containsAll(Arrays.asList("disease1", "disease2", "disease3", "disease5")));
                    assertFalse(specieList.contains("disease4"));
                });
    }
}
