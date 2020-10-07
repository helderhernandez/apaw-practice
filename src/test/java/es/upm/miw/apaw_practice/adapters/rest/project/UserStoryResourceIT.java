package es.upm.miw.apaw_practice.adapters.rest.project;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class UserStoryResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .get()
                .uri(UserStoryResource.USER_STORY + UserStoryResource.ID_ID, "")
                .exchange()
                .expectStatus().isNotFound();
    }

}
