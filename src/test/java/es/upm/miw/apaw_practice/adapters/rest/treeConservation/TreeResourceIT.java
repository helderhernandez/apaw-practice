package es.upm.miw.apaw_practice.adapters.rest.treeConservation;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.treeConservation.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static es.upm.miw.apaw_practice.adapters.rest.treeConservation.TreeResource.SEARCH;
import static es.upm.miw.apaw_practice.adapters.rest.treeConservation.TreeResource.TREES;
import static org.junit.jupiter.api.Assertions.*;


@RestTestConfig
public class TreeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(TREES)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Tree.class)
                .value(Assertions::assertNotNull)
                .value(trees -> assertEquals("young", trees.get(0).getAge()))
                .value(trees -> assertEquals("mature", trees.get(1).getAge()))
                .value(trees -> assertEquals("old", trees.get(2).getAge()))
                .value(trees -> assertEquals("young", trees.get(3).getAge()))
                .value(trees -> assertEquals("mature", trees.get(4).getAge()))
                .value(trees -> assertEquals("old", trees.get(5).getAge()));
    }

    @Test
    void testFindByInspectorId() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(TREES + SEARCH)
                        .queryParam("q", "dni:dni1")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(TreeSpecieDto.class)
                .consumeWith(entityList -> {
                    assertNotNull(entityList.getResponseBody());
                    List<String> specieList = entityList.getResponseBody().stream()
                            .map(TreeSpecieDto::getSpecie)
                            .collect(Collectors.toList());
                    assertTrue(specieList.containsAll(Arrays.asList("specie1", "specie2")));
                    assertFalse(specieList.contains("specie3"));
                });
    }
}
