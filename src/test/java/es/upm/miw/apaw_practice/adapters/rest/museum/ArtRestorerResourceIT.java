package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.ArtRestorer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testFindArtRestorerJobTitlesByArtistCountry(){
        String artistCountry = "Country1";
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ArtRestorerResource.ART_RESTORERS + ArtRestorerResource.SEARCH)
                                .queryParam("q", "country:" + artistCountry + ";")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ArtRestorerJobTitleDto.class)
                .value(artRestorerJobTitleDtoList -> assertTrue(artRestorerJobTitleDtoList.size() > 0))
                .value(artRestorerJobTitleDtoList -> artRestorerJobTitleDtoList.get(0).getArtRestorerJobTitle(), equalTo("Title1"));
    }

    @Test
    void testFindArtRestorerJobTitlesByArtistCountryNotFound(){
        String artistCountry = "Country2";
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ArtRestorerResource.ART_RESTORERS + ArtRestorerResource.SEARCH)
                                .queryParam("q", "country:" + artistCountry + ";")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ArtRestorerJobTitleDto.class)
                .value(artRestorerJobTitleDtoList -> assertTrue(artRestorerJobTitleDtoList.size() == 0));
    }
}
