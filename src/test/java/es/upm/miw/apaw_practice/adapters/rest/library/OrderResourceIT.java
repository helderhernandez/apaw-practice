package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.library.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class OrderResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll(){
        this.webTestClient
                .get()
                .uri(OrderResource.ORDER)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Order.class)
                .value(Assertions::assertNotNull)
                .hasSize(5);
    }




}
