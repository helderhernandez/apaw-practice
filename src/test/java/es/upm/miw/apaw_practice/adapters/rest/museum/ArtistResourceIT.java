package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.shop.ArticleResource;
import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import es.upm.miw.apaw_practice.domain.models.museum.ArtistCountryUpdating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class ArtistResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(ArtistResource.ARTISTS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Artist.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testUpdateCountry() {
        ArtistCountryUpdating artistCountryUpdating = new ArtistCountryUpdating("AAA1", "Country5");
        this.webTestClient
                .patch()
                .uri(ArtistResource.ARTISTS)
                .body(BodyInserters.fromValue(artistCountryUpdating))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Artist.class);
    }


}
