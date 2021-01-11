package es.upm.miw.apaw_practice.adapters.rest.adCampaign;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class AdCampaignResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(AdCampaignResource.AD_CAMPAIGNS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BasicAdCampaignDto.class)
                .value(Assertions::assertNotNull);
    }
}
