package es.upm.miw.apaw_practice.adapters.rest.adCampaign;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.adCampaign.Likes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class LikesResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        Likes likes = new Likes("likes-06", "Anime", "Naruto, Cars");

        this.webTestClient
                .post()
                .uri(LikesResource.LIKES)
                .body(BodyInserters.fromValue(likes))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Likes.class)
                .value(Assertions::assertNotNull)
                .value(likesData -> assertNotNull(likesData.getId()));
    }

    @Test
    void testCreateConflict() {
        Likes likes = new Likes("likes-03", "Anime", "Naruto, Cars");
        this.webTestClient
                .post()
                .uri(LikesResource.LIKES)
                .body(BodyInserters.fromValue(likes))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    void testFindByPromotionTitle() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(LikesResource.LIKES + LikesResource.SEARCH)
                        .queryParam("q", "title:enero2020")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Likes.class)
                .consumeWith(listEntityExchangeResult -> {
                    List<String> list = listEntityExchangeResult.getResponseBody().stream()
                            .map(Likes::getId)
                            .collect(Collectors.toList());
                    assertTrue(list.containsAll(Arrays.asList("likes-01", "likes-03")));
                    assertFalse(list.containsAll(Arrays.asList("likes-02")));
                });
    }
}
