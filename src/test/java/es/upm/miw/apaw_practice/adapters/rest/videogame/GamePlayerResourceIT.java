package es.upm.miw.apaw_practice.adapters.rest.videogame;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.GameDeveloperRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.GamePlayerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GamePlayerEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class GamePlayerResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @Test
    void testDeleteById(){
        GamePlayerEntity gamePlayerEntity = gamePlayerRepository.save(new GamePlayerEntity());

        this.webTestClient
                .delete()
                .uri(GamePlayerResource.GAMEPLAYERS + GamePlayerResource.ID, gamePlayerEntity.getId())
                .exchange()
                .expectStatus().isOk();
    }


}