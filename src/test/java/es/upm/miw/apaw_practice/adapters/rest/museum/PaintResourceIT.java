package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.museum.ArtRestorer;
import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import es.upm.miw.apaw_practice.domain.models.museum.Paint;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static es.upm.miw.apaw_practice.adapters.rest.museum.PaintResource.PAINTS;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class PaintResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {

        List<ArtRestorer> artRestorers = new ArrayList<>();
        artRestorers.add(new ArtRestorer("1", "ArtRestorer", "ARSurname1", "JobTitle1"));

        Paint paint = new Paint("Paint1", LocalDate.now(),"Technique1", true,
                new Artist("1", "Artist1", "ASurname1", "Artist Country"),
                artRestorers);
        this.webTestClient
                .post()
                .uri(PAINTS)
                .body(BodyInserters.fromValue(paint))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Article.class)
                .value(Assertions::assertNotNull)
                .value(paintData -> assertNotNull(paintData.getId()));
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(PAINTS + PaintResource.ID_ID, "PPP2")
                .exchange()
                .expectStatus().isOk();
    }
}
