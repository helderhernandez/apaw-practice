package es.upm.miw.apaw_practice.adapters.rest.videogame;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.videogame.Challenge;
import es.upm.miw.apaw_practice.domain.models.videogame.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class LevelResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(LevelResource.LEVELS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Level.class)
                .value(Assertions::assertNotNull)
                .value(levels -> assertEquals("level_1", levels.get(0).getDescription()))
                .value(levels -> assertEquals("Pedro", levels.get(1).getGameDeveloper().getName()));

    }




}