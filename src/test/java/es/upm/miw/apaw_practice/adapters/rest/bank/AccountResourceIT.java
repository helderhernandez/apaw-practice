package es.upm.miw.apaw_practice.adapters.rest.bank;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.bank.AccountItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

@RestTestConfig
public class AccountResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateAmount() {
        AccountItem accountItem = new AccountItem(BigDecimal.ZERO);
        this.webTestClient
                .put()
                .uri(AccountResource.ACCOUNTS + AccountResource.ID_ID + AccountResource.AMOUNT, "notAnId")
                .body(BodyInserters.fromValue(accountItem))
                .exchange()
                .expectStatus().isNotFound();
    }
}
