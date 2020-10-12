package es.upm.miw.apaw_practice.adapters.rest.videoclub;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.videoclub.RentalFilm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.videoclub.RentalFilmResource.FILMS;
import static es.upm.miw.apaw_practice.adapters.rest.videoclub.RentalFilmResource.REF_REF;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class RentalFilmResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(FILMS + REF_REF, "4444")
                .exchange()
                .expectStatus().isOk()
                .expectBody(RentalFilm.class)
                .value(Assertions::assertNotNull)
                .value(rentalFilmData -> {
                    assertEquals("4444", rentalFilmData.getReference());
                    assertEquals("Generation Z", rentalFilmData.getTitle());
                    assertEquals(1998, rentalFilmData.getYear());
                    assertEquals("filmMaker4", rentalFilmData.getFilmMaker().getId());
                    assertEquals("cat4", rentalFilmData.getCategories().get(0).getId());
                });
    }
}
