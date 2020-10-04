package es.upm.miw.apaw_practice.adapters.rest.bank;


import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.bank.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class CustomerResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(CustomerResource.CUSTOMERS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Customer.class)
                .value(Assertions::assertNotNull);
    }


}
