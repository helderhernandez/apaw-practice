package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.hospital.Bed;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
class BedResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateOccupied(){
        this.webTestClient
                .put()
                .uri(BedResource.BEDS + BedResource.ID_ID + BedResource.OCCUPIED,"")
                .body(BodyInserters.fromValue(Boolean.TRUE))
                .exchange()
                .expectStatus().isNotFound();
    }

    /*@Test
    void testSearchByNameWidthOfBeds(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(BedResource.BEDS + BedResource.SEARCH)
                                .queryParam("q", "name:NameC")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Integer.class)
                ;//.value(beds -> assertTrue(beds. > 0))
                ;//.value(beds -> assertEquals(105, beds.get(0)));
    }*/

}
