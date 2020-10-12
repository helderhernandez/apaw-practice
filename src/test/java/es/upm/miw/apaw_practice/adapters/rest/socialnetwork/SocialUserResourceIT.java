package es.upm.miw.apaw_practice.adapters.rest.socialnetwork;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUser;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUserCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
