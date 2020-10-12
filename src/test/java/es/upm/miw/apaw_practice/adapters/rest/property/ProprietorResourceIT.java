package es.upm.miw.apaw_practice.adapters.rest.property;

import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.ProprietorEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.property.Proprietor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RestTestConfig
public class ProprietorResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll(){
        this.webTestClient
                .get()
                .uri(ProprietorResource.PROPRIETORS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Proprietor.class)
                .value(Assertions::assertNotNull)
                .hasSize(6);
    }
}