package es.upm.miw.apaw_practice.adapters.rest.bank;


import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.bank.Customer;
import es.upm.miw.apaw_practice.domain.models.bank.CustomerCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    void testCreate() {
        CustomerCreation customerCreation = new CustomerCreation("Calpurnia", "159753264C");
        this.webTestClient
                .post()
                .uri(CustomerResource.CUSTOMERS)
                .body(BodyInserters.fromValue(customerCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Customer.class)
                .value(Assertions::assertNotNull)
                .value(customerData -> assertNotNull(customerData.getId()));
    }

}
