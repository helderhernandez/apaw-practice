package es.upm.miw.apaw_practice.adapters.rest.sportcentre;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class SessionResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete(){
        this.webTestClient
                .delete()
                .uri(SessionResource.SESSIONS + SessionResource.ID_ID, "not_id")
                .exchange()
                .expectStatus().isOk();
    }

}
