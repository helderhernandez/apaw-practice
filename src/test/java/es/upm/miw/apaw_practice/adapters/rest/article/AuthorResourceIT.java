package es.upm.miw.apaw_practice.adapters.rest.article;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.article.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class AuthorResourceIT {

    @Autowired
    private WebTestClient webTestClient;
    @Test
    void testReadAll(){
        this.webTestClient
                .get()
                .uri(AuthorResource.AUTHORS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Author.class)
                .value(Assertions::assertNotNull)
                .hasSize(5);
    }
}
