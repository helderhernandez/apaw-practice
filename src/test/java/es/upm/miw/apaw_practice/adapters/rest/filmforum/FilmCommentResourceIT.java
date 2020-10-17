package es.upm.miw.apaw_practice.adapters.rest.filmforum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class FilmCommentResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        webTestClient.delete()
                .uri(FilmCommentResource.COMMENT + "/4")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testFindContentsOfCommentFromFilmsOfActor() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path(FilmCommentResource.COMMENT + FilmCommentResource.ACTOR)
                        .queryParam("q", "name:actor1")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class);
    }

}
