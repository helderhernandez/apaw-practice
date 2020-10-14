package es.upm.miw.apaw_practice.adapters.rest.videogame;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.ChallengeRepository;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.videogame.Challenge;
import es.upm.miw.apaw_practice.domain.models.videogame.ChallengeDescriptionUpdating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class ChallengeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ChallengeRepository challengeRepository;

    @Test
    void testUpdateDescription(){
        List<ChallengeDescriptionUpdating> challengeDescriptionUpdatingList = challengeRepository
                .findAll()
                .stream()
                .map(challengeEntity -> new ChallengeDescriptionUpdating(challengeEntity.getId(), "collect green beans", false))
                .collect(Collectors.toList());

        this.webTestClient
                .patch()
                .uri(ChallengeResource.CHALLENGES)
                .body(BodyInserters.fromValue(challengeDescriptionUpdatingList))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateDescriptionNotFound(){
        List<ChallengeDescriptionUpdating> challengeDescriptionUpdatingList = Arrays.asList(
                new ChallengeDescriptionUpdating("0a","take red flag", false)
        );

        this.webTestClient
                .patch()
                .uri(ChallengeResource.CHALLENGES)
                .body(BodyInserters.fromValue(challengeDescriptionUpdatingList))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindCompletedChallengesByDescription() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(ChallengeResource.CHALLENGES + LevelResource.SEARCH)
                        .queryParam("q", "description:level_1")
                        .build())
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Challenge.class)
                .value(challengeList -> assertTrue(challengeList.get(0).getCompleted()));


    }
}