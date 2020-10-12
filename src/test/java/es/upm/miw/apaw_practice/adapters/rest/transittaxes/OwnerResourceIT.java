package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;


@RestTestConfig
public class OwnerResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDeleteById() {
        this.webTestClient
                .delete()
                .uri(OwnerResource.OWNERS + OwnerResource.ID_ID, "ow5")
                .exchange()
                .expectStatus().isOk();
    }

}
