package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.music.MusicItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

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
}
