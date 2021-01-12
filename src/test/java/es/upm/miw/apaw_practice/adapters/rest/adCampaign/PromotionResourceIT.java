package es.upm.miw.apaw_practice.adapters.rest.adCampaign;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.adCampaign.Promotion;
import es.upm.miw.apaw_practice.domain.models.adCampaign.PromotionHeaderUpdating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
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
        List<PromotionHeaderUpdating> promotionHeaderUpdatingList = Arrays.asList(
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

}
