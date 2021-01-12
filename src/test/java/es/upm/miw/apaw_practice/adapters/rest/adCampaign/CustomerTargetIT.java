package es.upm.miw.apaw_practice.adapters.rest.adCampaign;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.adCampaign.CustomerTarget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class CustomerTargetIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateName() {
        NameDto nameDto = new NameDto();
        nameDto.setName("mi nuevo nombre");
        String id = "customer-01";
        this.webTestClient
                .put()
                .uri(CustomerTargetResource.CUSTOMER_TARGET + CustomerTargetResource.ID_ID + CustomerTargetResource.NAME, id)
                .body(BodyInserters.fromValue(nameDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(CustomerTarget.class)
                .value(Assertions::assertNotNull)
                .value(customerTargetData -> assertEquals(nameDto.getName(), customerTargetData.getName()));
    }

    @Test
    void testUpdateNameNotFound() {
        NameDto nameDto = new NameDto();
        nameDto.setName("mi nuevo nombre");
        String id = "customer-not01";
        this.webTestClient
                .put()
                .uri(CustomerTargetResource.CUSTOMER_TARGET + CustomerTargetResource.ID_ID + CustomerTargetResource.NAME, id)
                .body(BodyInserters.fromValue(nameDto))
                .exchange()
                .expectStatus().isNotFound();
    }
}
