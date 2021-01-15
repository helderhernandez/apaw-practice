package es.upm.miw.apaw_practice.adapters.rest.adCampaign;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;

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

    @Test
    void testFindIdByLikesFromCustomerName() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(AdCampaignResource.AD_CAMPAIGNS + AdCampaignResource.SEARCH)
                        .queryParam("q", "name:Tomas")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(IdDto.class)
                .value(idDtos -> Arrays.asList("adCampaign-01", "adCampaign-01").containsAll(idDtos));
    }

    @Test
    void testFindIdByLikesFromCustomerNameEmptyResult() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(AdCampaignResource.AD_CAMPAIGNS + AdCampaignResource.SEARCH)
                        .queryParam("q", "name:David")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(IdDto.class)
                .hasSize(0);
    }
}
