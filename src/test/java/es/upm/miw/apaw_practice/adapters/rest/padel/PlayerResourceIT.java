package es.upm.miw.apaw_practice.adapters.rest.padel;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.padel.Player;
import es.upm.miw.apaw_practice.domain.models.padel.PlayerCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class PlayerResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate(){
        PlayerCreation playerCreation =
                new PlayerCreation("A","AA","00000000A","aaaa@aaaa.com",true);
        this.webTestClient
                .post()
                .uri(PlayerResource.PLAYERS)
                .body(BodyInserters.fromValue(playerCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Player.class)
                .value(Assertions::assertNotNull)
                .value(articleData -> assertNotNull(articleData.getId()));
    }
}
