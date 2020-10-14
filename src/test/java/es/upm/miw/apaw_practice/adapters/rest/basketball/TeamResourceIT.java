package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class TeamResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDeleteById() {
        this.webTestClient
                .delete()
                .uri(TeamResource.TEAMS + TeamResource.ID_ID, "id")
                .exchange()
                .expectStatus().isOk();
    }
}
