package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.music.Style;
import es.upm.miw.apaw_practice.domain.models.music.StyleDescriptionUpdating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class StyleResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate(){
        Style styleCreation =
                new Style("RAP","ASDAFDFGAG");
        this.webTestClient
                .post()
                .uri(StyleResource.STYLES)
                .body(BodyInserters.fromValue(styleCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Style.class)
                .value(Assertions::assertNotNull)
                .value(styleData -> assertNotNull(styleData.getId()));
    }

    @Test
    void testCreateConflict(){
        Style styleCreation =
                new Style("POP","Pop is a genre of popular music that originated in its modern form during the mid-1950s in the United States and the United Kingdom.");
        this.webTestClient
                .post()
                .uri(StyleResource.STYLES)
                .body(BodyInserters.fromValue(styleCreation))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    void testUpdateDescriptionNotFound(){
        List<StyleDescriptionUpdating> styleDescriptionUpdatingList = Arrays.asList(
                new StyleDescriptionUpdating("ROCK","asdfsadvksdivfk")
        );
        this.webTestClient
                .patch()
                .uri(StyleResource.STYLES)
                .body(BodyInserters.fromValue(styleDescriptionUpdatingList))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdateDescription(){
        List<StyleDescriptionUpdating> styleDescriptionUpdatingList = Arrays.asList(
                new StyleDescriptionUpdating("POP","DSAFASFSFDFASDF"),
                new StyleDescriptionUpdating("BLUES","AFDASFDADSGASDGF")
        );
        this.webTestClient
                .patch()
                .uri(StyleResource.STYLES)
                .body(BodyInserters.fromValue(styleDescriptionUpdatingList))
                .exchange()
                .expectStatus().isOk();
    }

}
