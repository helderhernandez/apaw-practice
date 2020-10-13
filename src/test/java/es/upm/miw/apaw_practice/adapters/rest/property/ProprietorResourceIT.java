package es.upm.miw.apaw_practice.adapters.rest.property;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.property.Proprietor;
import es.upm.miw.apaw_practice.domain.models.property.ProprietorEmailUpdating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                .hasSize(9);
    }

    @Test
    void testUpdateEmailsNotFound() {
        List<ProprietorEmailUpdating> proprietorEmailUpdatingList = Arrays.asList(
                new ProprietorEmailUpdating("20180553E", "frank@gmail.com")
        );
        this.webTestClient
                .patch()
                .uri(ProprietorResource.PROPRIETORS)
                .body(BodyInserters.fromValue(proprietorEmailUpdatingList))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateEmails() {
        List<ProprietorEmailUpdating> proprietorEmailUpdatingList = Arrays.asList(
                new ProprietorEmailUpdating("35274690B", "palomacambio@gmail.com"),
                new ProprietorEmailUpdating("97653915F", "fridacambio@gmail.com")
        );
        this.webTestClient
                .patch()
                .uri(ProprietorResource.PROPRIETORS)
                .body(BodyInserters.fromValue(proprietorEmailUpdatingList))
                .exchange()
                .expectStatus().isOk();
        assertEquals("frida@gmail.com", this.webTestClient
                .get()
                .uri(ProprietorResource.PROPRIETORS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Proprietor.class)
                .returnResult()
                .getResponseBody()
                .get(1)
                .getEmail());
    }
}