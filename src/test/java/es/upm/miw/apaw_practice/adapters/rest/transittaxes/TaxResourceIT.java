package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import es.upm.miw.apaw_practice.domain.models.transittaxes.TaxCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class TaxResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        TaxCreation taxCreation = new TaxCreation("TAX005", "Speeding", new BigDecimal("150.00"), false);
        this.webTestClient
                .post()
                .uri(TaxResource.TAXES)
                .body(BodyInserters.fromValue(taxCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Tax.class)
                .value(taxBD -> assertNotNull(taxBD.getId()));
    }

    @Test
    void testCreateConflict() {
        TaxCreation taxCreation = new TaxCreation("TAX004", "REPEAT", new BigDecimal("150.00"), false);
        this.webTestClient
                .post()
                .uri(TaxResource.TAXES)
                .body(BodyInserters.fromValue(taxCreation))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
