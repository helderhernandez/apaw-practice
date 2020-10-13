package es.upm.miw.apaw_practice.adapters.rest.property;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class MaintanenceItemResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(MaintanenceItemResource.ITEMS + MaintanenceItemResource.ID_ID, "abc")
                .exchange()
                .expectStatus().isOk();
    }
}