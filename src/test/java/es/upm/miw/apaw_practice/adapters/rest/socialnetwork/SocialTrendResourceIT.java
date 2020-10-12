package es.upm.miw.apaw_practice.adapters.rest.socialnetwork;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialTrendPositionUpdating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;

@RestTestConfig
public class SocialTrendResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdatePositionsNotFound() {
        List<SocialTrendPositionUpdating> socialTrendPositionUpdatingList = Arrays.asList(
                new SocialTrendPositionUpdating("ko", 7)
        );
        this.webTestClient.patch()
                .uri(SocialTrendResource.TRENDS)
                .body(BodyInserters.fromValue(socialTrendPositionUpdatingList))
                .exchange()
                .expectStatus().isNotFound();
    }

}
