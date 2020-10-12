package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.music.Singer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class SingerResourceIT {

    @Autowired
    private WebTestClient webTestClient;
    @Test
    void testReadAll(){
        this.webTestClient
                .get()
                .uri(SingerResource.SINGERS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Singer.class)
                .value(Assertions::assertNotNull)
                .hasSize(3);
    }

}
