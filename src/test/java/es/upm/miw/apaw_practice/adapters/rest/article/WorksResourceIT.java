package es.upm.miw.apaw_practice.adapters.rest.article;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class WorksResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete(){
        this.webTestClient
                .delete()
                .uri(WorksResource.WORKSES + WorksResource.ID_ID,"kk")
                .exchange()
                .expectStatus().isOk();
    }
}
