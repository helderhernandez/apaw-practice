package es.upm.miw.apaw_practice.adapters.rest.transport;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.shop.ArticleItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestTestConfig
class DepartmentResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateNotFound() {
        List<ArticleItem> articleItemArray = Arrays.asList(
                new ArticleItem(84002L, 2, BigDecimal.ONE),
                new ArticleItem(84003L, 3, BigDecimal.TEN)
        );

        UbicationDto ubicationDto = new UbicationDto();
        ubicationDto.setUbication("newUbication");

        this.webTestClient
                .put()
                .uri(DepartmentResource.DEPARTMENTS + DepartmentResource.NAME_NAME + DepartmentResource.UBICATION, "kkk")
                .body(BodyInserters.fromValue(ubicationDto))
                .exchange()
                .expectStatus().isNotFound();
    }
}
