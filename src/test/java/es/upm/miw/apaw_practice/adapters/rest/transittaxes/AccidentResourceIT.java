package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Accident;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class AccidentResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(AccidentResource.ACCIDENTS + AccidentResource.ID_ID, "001")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Accident.class)
                .value(Assertions::assertNotNull)
                .value(AccidentData -> {
                    assertEquals("ACC001", AccidentData.getRefAccident());
                    assertEquals("Toledo", AccidentData.getPlace());
                    assertEquals(LocalDateTime.of(2020, 10, 5, 5, 0), AccidentData.getDate());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(AccidentResource.ACCIDENTS + AccidentResource.ID_ID, "009")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdatePlaceNotFound() {
        Accident accident = new Accident();
        accident.setRefAccident("ACC009");
        accident.setPlace("Barcelona");
        this.webTestClient
                .patch()
                .uri(AccidentResource.ACCIDENTS)
                .body(BodyInserters.fromValue(accident))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindRefAccidentsByNameOwner() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(AccidentResource.ACCIDENTS + AccidentResource.SEARCH)
                                .queryParam("q", "name:Lucas")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Accident.class)
                .value(accidents -> assertEquals("ACC002", accidents.get(0).getRefAccident()))
                .value(accidents -> assertEquals("ACC003", accidents.get(1).getRefAccident()))
                .value(accidents -> assertEquals("ACC004", accidents.get(2).getRefAccident()))
                .value(accidents -> assertEquals("ACC005", accidents.get(3).getRefAccident()));
    }


}
