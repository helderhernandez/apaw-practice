package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class PatronResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testFindPatronsIDByArtistName() {
        String artistName = "Artist1";
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(PatronResource.PATRONS + PatronResource.SEARCH)
                                .queryParam("q", "name:" + artistName + ";")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(strings -> assertTrue(strings.size() > 0));
    }

}
