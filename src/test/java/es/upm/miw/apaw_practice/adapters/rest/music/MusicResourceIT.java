package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.music.MusicItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class MusicResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateNotFound(){
        MusicItem musicName = new MusicItem("The Best For You");
        this.webTestClient
                .put()
                .uri(MusicResource.MUSICS + MusicResource.ID_ID + MusicResource.NAME, "kkk")
                .body(BodyInserters.fromValue(musicName))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindMusicBySingerName(){
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(MusicResource.MUSICS + MusicResource.SEARCH)
                        .queryParam("q","name:Bruno")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .consumeWith(entityList ->{
                    assertNotNull(entityList.getResponseBody());
                    List<String> nameMusic = entityList.getResponseBody();
                    assertTrue(nameMusic.get(0).contains("Fly to moon"));
                });
    }
}
