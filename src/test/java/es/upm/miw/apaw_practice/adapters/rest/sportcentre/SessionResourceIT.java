package es.upm.miw.apaw_practice.adapters.rest.sportcentre;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.sportcentre.BasicSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class SessionResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete(){
        this.webTestClient
                .delete()
                .uri(SessionResource.SESSIONS + SessionResource.ID_ID, "not_id")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testFindInSessionByName(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(SessionResource.SESSIONS + SessionResource.SEARCH)
                                .queryParam("name", "Gonzalo")
                                .build())
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testFindInSessionByTitle(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(SessionResource.SESSIONS + SessionResource.SEARCH)
                                .queryParam("title", "Yoga")
                                .build())
                .exchange()
                .expectStatus().isOk();
    }

}
