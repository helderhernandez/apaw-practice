
package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class AlbumResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete(){
        this.webTestClient
                .delete()
                .uri(AlbumResource.ALBUMS + AlbumResource.ID_ID,"kk")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testFindTotalPriceAlbumByStyleName(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(AlbumResource.ALBUMS + AlbumResource.SEARCH)
                        .queryParam("q","name:POP")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BigDecimal.class)
                .value(album ->  assertEquals(new BigDecimal("59.97"),album.get(0)));
    }
}
