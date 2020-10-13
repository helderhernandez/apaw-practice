package es.upm.miw.apaw_practice.adapters.rest.garage;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.garage.Mechanic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class MechanicResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(MechanicResource.MECHANICS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Mechanic.class)
                .consumeWith(entityList -> {
                    assertNotNull(entityList.getResponseBody());
                    List<String> mechanicTlfList = entityList.getResponseBody().stream()
                            .map(Mechanic::getTelephone)
                            .collect(Collectors.toList());
                    assertTrue(mechanicTlfList.containsAll(Arrays.asList("689555666", "333444555", "111222333", "555666777")));
                });
    }

}
