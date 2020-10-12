package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.restaurant.PhysicalStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class PhysicalStoreResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate(){
        PhysicalStore physicalStore =
                new PhysicalStore("Calle4", 500, true, LocalDateTime.now());
        this.webTestClient
                .post()
                .uri(PhysicalStoreResource.PHYSICALSTORES)
                .body(BodyInserters.fromValue(physicalStore))
                .exchange()
                .expectStatus().isOk()
                .expectBody(PhysicalStore.class)
                .value(Assertions::assertNotNull)
                .value(store -> assertNotNull(store.getAddress()))
                .value(store -> assertEquals("Calle4", store.getAddress()));
    }

    @Test
    void testCreateConflict(){
        PhysicalStore physicalStore =
                new PhysicalStore("address1", 500, true, LocalDateTime.now());
        this.webTestClient
                .post()
                .uri(PhysicalStoreResource.PHYSICALSTORES)
                .body(BodyInserters.fromValue(physicalStore))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
