package es.upm.miw.apaw_practice.adapters.rest.socialnetwork;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUser;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUserCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class SocialUserResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        SocialUserCreation socialUserCreation = new SocialUserCreation("TestUser", "I'm the test user", true);
        this.webTestClient.post()
                .uri(SocialUserResource.USERS)
                .body(BodyInserters.fromValue(socialUserCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SocialUser.class)
                .value(Assertions::assertNotNull)
                .value(socialUser -> assertNotNull(socialUser.getId()));
    }

    @Test
    void testCreateConflict() {
        SocialUserCreation socialUserCreation = new SocialUserCreation("Juan13", "Bio", false);
        this.webTestClient.post()
                .uri(SocialUserResource.USERS)
                .body(BodyInserters.fromValue(socialUserCreation))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    void testUpdateBiographyNotFound() {
        BiographyDto biographyDto = new BiographyDto();
        biographyDto.setBiography("This is the new biography");
        this.webTestClient.put()
                .uri(SocialUserResource.USERS + SocialUserResource.ID + SocialUserResource.BIOGRAPHY, "ko")
                .body(BodyInserters.fromValue(biographyDto))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindNickNamesByTrendName() {
        this.webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path(SocialUserResource.USERS + SocialUserResource.SEARCH)
                        .queryParam("q", "trendName:Europan")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .consumeWith(entitiesList -> {
                    assertNotNull(entitiesList);
                    assertNotNull(entitiesList.getResponseBody());
                    assertTrue(entitiesList.getResponseBody().size() > 0 && entitiesList.getResponseBody().get(0).contains("Famoso_oficial"));
                });
    }

}
