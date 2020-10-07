package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.hospital.IllnessContagiousUpdating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;

@RestTestConfig
class IllnessResourceIT {

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

    @Test
    void testUpdateContagious(){
        IllnessContagiousUpdating illnessContagiousUpdating = new IllnessContagiousUpdating(4,true);

        this.webTestClient
                .patch()
                .uri(IllnessResource.ILLNESES)
                .body(BodyInserters.fromValue(illnessContagiousUpdating))
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void testUpdateContagiousNotFound(){
        IllnessContagiousUpdating illnessContagiousUpdating = new IllnessContagiousUpdating(7,true);

        this.webTestClient
                .patch()
                .uri(IllnessResource.ILLNESES)
                .body(BodyInserters.fromValue(illnessContagiousUpdating))
                .exchange()
                .expectStatus()
                .isNotFound();
    }

}
