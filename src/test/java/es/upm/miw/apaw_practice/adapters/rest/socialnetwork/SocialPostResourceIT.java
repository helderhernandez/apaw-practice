package es.upm.miw.apaw_practice.adapters.rest.socialnetwork;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class SocialPostResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(SocialPostResource.POSTS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BasicPostDto.class)
                .value(Assertions::assertNotNull);
    }

}
