package es.upm.miw.apaw_practice.adapters.rest.studio;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.studio.Tattoist;
import es.upm.miw.apaw_practice.domain.models.studio.TattoistItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class TattoistResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(TattoistResource.TATTOIST)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BasicTattoistDto.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testUpdateNickname() {
        TattoistItem tattoistItem = new TattoistItem("BOB");
        this.webTestClient
                .put()
                .uri(TattoistResource.TATTOIST + TattoistResource.ID + TattoistResource.NICKNAME, "isNotAnId")
                .body(BodyInserters.fromValue(tattoistItem))
                .exchange()
                .expectStatus().isNotFound();
    }
}
