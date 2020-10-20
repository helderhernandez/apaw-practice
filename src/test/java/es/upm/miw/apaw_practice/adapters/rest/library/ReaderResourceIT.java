package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.library.Reader;
import es.upm.miw.apaw_practice.domain.models.library.ReaderCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class ReaderResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate(){
        ReaderCreation readerCreation=new ReaderCreation("Ana3","Woman","0164846d33T","695222111","waldujocnj@gmail.com");
        this.webTestClient
                .post()
                .uri(ReaderResource.READER)
                .body(BodyInserters.fromValue(readerCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Reader.class)
                .value(Assertions::assertNotNull)
                .value(readerData->assertNotNull(readerData.getId()));
    }

    @Test
    void findNameByBookISBN(){
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(ReaderResource.READER+ReaderResource.SEARCH)
                        .queryParam("q","ISBN:9787111636623")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Reader.class)
                .value(readers -> assertEquals("Maria",readers.get(0).getName()));
    }
}
