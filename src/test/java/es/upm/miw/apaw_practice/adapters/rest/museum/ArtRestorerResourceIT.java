package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.ArtRestorer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class ArtRestorerResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdated() {

        ArtRestorer artRestorer =
                new ArtRestorer("ARR4", "Art_Restorer_4","ArtRestorer_Surname4", "Title4");
        this.webTestClient
                .put()
                .uri(ArtRestorerResource.ART_RESTORERS + ArtRestorerResource.ID_ID,artRestorer.getId())
                .body(BodyInserters.fromValue(artRestorer))
                .exchange()
                .expectStatus().isOk();
    }
    @Test
    void testUpdateNotFound() {

        ArtRestorer artRestorer =
                new ArtRestorer("ARR5", "Art_Restorer_4","ArtRestorer_Surname4", "Title4");
        this.webTestClient
                .put()
                .uri(ArtRestorerResource.ART_RESTORERS + ArtRestorerResource.ID_ID,artRestorer.getId())
                .body(BodyInserters.fromValue(artRestorer))
                .exchange()
                .expectStatus().isNotFound();
    }


}
