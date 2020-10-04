package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class IllnessResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll(){
        this.webTestClient
                .get()
                .uri(IllnessResource.ILLNESES)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BasicIllnessDto.class)
                .value(Assertions::assertNotNull);
    }
}
