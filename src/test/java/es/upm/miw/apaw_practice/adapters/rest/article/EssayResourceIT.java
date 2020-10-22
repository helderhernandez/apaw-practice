package es.upm.miw.apaw_practice.adapters.rest.article;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.article.EssayItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class EssayResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateNotFound(){
        EssayItem essayName = new EssayItem("Caperucita Roja");
        this.webTestClient
                .put()
                .uri(EssayResource.ESSAIES + EssayResource.ID_ID + EssayResource.NAME, "kkk")
                .body(BodyInserters.fromValue(essayName))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void findEssayIdByAuthor(){
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(EssayResource.ESSAIES + EssayResource.SEARCH)
                        .queryParam("q","nationality:America")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .consumeWith(entityList ->{
                    assertNotNull(entityList.getResponseBody());
                    List<String> idEssay = entityList.getResponseBody();
                    assertTrue(idEssay.get(0).contains("86958"));
                });
    }
}
