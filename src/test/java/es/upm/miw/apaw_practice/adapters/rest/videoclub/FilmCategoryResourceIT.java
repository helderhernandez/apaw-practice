package es.upm.miw.apaw_practice.adapters.rest.videoclub;

import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.VideoclubSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategory;
import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategoryAdultUpdating;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
class FilmCategoryResourceIT {

    @Autowired
    private VideoclubSeederService videoclubSeederService;

    @Autowired
    private WebTestClient webTestClient;

    @AfterEach
    void resetBBDD() {
        videoclubSeederService.deleteAll();
        videoclubSeederService.seedDatabase();
    }

    @Test
    void testUpdatePlus18() {
        List<FilmCategoryAdultUpdating> filmCategoryAdultUpdatings = Arrays.asList(
                new FilmCategoryAdultUpdating("cat1", true)
        );

        this.webTestClient
                .patch()
                .uri(FilmCategoryResource.FILMS_CATEGORIES +
                        FilmCategoryResource.PLUS_18)
                .body(BodyInserters.fromValue(filmCategoryAdultUpdatings))
                .exchange()
                .expectStatus().isOk();

        this.webTestClient
                .get()
                .uri(FilmCategoryResource.FILMS_CATEGORIES + FilmCategoryResource.REF_REF, "cat1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(FilmCategory.class)
                .value(Assertions::assertNotNull)
                .value(filmCategoryData -> {
                    assertEquals("cat1", filmCategoryData.getReference());
                    assertEquals("Action", filmCategoryData.getName());
                    assertTrue(filmCategoryData.getPlus18());
                });
    }

    @Test
    void testFindDistinctPlus18NameByFilmMaker() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(FilmCategoryResource.FILMS_CATEGORIES + FilmCategoryResource.SEARCH)
                                .queryParam("q", "gender:F")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(NameDto.class)
                .value(Assertions::assertNotNull)
                .value(name -> assertEquals("War", name.get(0).getName()));
    }
}
