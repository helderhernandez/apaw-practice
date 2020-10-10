package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
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
        Tax tax = new Tax();
        tax.setRefTax("TAX005");
        tax.setDescription("Speeding");
        tax.setPrice(new BigDecimal("150.00"));
        tax.setPaid(false);
        this.webTestClient
                .post()
                .uri(TaxResource.TAXES)
                .body(BodyInserters.fromValue(tax))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Tax.class)
                .value(taxBD -> assertNotNull(taxBD.getRefTax()));
    }

    @Test
    void testCreateConflict() {

        Tax tax = new Tax();
        tax.setRefTax("TAX004");
        tax.setDescription("REPEAT");
        tax.setPrice(new BigDecimal("150.00"));
        tax.setPaid(false);
        this.webTestClient
                .post()
                .uri(TaxResource.TAXES)
                .body(BodyInserters.fromValue(tax))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
