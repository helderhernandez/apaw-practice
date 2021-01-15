package es.upm.miw.apaw_practice.adapters.rest.adCampaign;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.adCampaign.Promotion;
import es.upm.miw.apaw_practice.domain.models.adCampaign.PromotionHeaderUpdating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class PromotionResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateHeadersNotFound() {
        List<PromotionHeaderUpdating> promotionHeaderUpdatingList = Arrays.asList(
                new PromotionHeaderUpdating("promotion-not01", "header1"),
                new PromotionHeaderUpdating("promotion-not0", "header2")
        );

        this.webTestClient
                .patch()
                .uri(PromotionResource.PROMOTIONS)
                .body(BodyInserters.fromValue(promotionHeaderUpdatingList))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdateHeaders() {
        List<PromotionHeaderUpdating> promotionHeaderUpdatingList = Collections.singletonList(
                new PromotionHeaderUpdating("promotion-01", "header1")
        );
        this.webTestClient
                .patch()
                .uri(PromotionResource.PROMOTIONS)
                .body(BodyInserters.fromValue(promotionHeaderUpdatingList))
                .exchange()
                .expectStatus().isOk();
        assertEquals("header1", this.webTestClient
                .get()
                .uri(PromotionResource.PROMOTIONS + PromotionResource.ID_ID, promotionHeaderUpdatingList.get(0).getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Promotion.class)
                .returnResult()
                .getResponseBody()
                .getHeader());
    }

    @Test
    void testFindByAdCampaignWithLikeName() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(PromotionResource.PROMOTIONS + PromotionResource.SEARCH)
                        .queryParam("q", "like-name:Artes")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Promotion.class)
                .value(promotions -> Arrays.asList("promotion-01", "promotion-03").containsAll(promotions));
    }

    @Test
    void testFindByAdCampaignWithLikeNameBadRequest() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(PromotionResource.PROMOTIONS + PromotionResource.SEARCH)
                        .queryParam("q", "otro-param:Artes")
                        .build())
                .exchange()
                .expectStatus().isBadRequest();
    }

}
