package es.upm.miw.apaw_practice.adapters.rest.videogame;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.GameDeveloperRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.GamePlayerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GamePlayerEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.services.videogame.GamePlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void testFindNickNameByGameDeveloper(){
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(GamePlayerResource.GAMEPLAYERS + GamePlayerResource.SEARCH)
                        .queryParam("q", "name:Pedro")
                        .build())
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(NickNameDto.class)
                .value(nickNameDtos -> assertEquals("natcas", nickNameDtos.get(0).getName()));
    }

    @Test
    void testFindNickNamByGameDeveloperBadRequest(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(GamePlayerResource.GAMEPLAYERS + GamePlayerResource.SEARCH)
                        .queryParam("q","kk:Pedro")
                        .build())
                .exchange()
                .expectStatus().isBadRequest();
    }



}