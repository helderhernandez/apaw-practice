package es.upm.miw.apaw_practice.adapters.rest.bank;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;

@RestTestConfig
public class ShareholderResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateExpirationDates() {
        LocalDateTime date = LocalDateTime.of(2023, 11, 7, 17, 45);
        this.webTestClient
                .patch()
                .uri(ShareholderResource.SHAREHOLDERS)
                .body(BodyInserters.fromValue(date))
                .exchange()
                .expectStatus().isOk();
    }
}
