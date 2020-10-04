package es.upm.miw.apaw_practice.adapters.rest.sportcentre;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.factory.MachineResource;
import es.upm.miw.apaw_practice.domain.models.factory.Machine;
import es.upm.miw.apaw_practice.domain.models.factory.MachineItem;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Assistant;
import es.upm.miw.apaw_practice.domain.models.sportcentre.AssistantItem;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Speciality;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Objects;

@RestTestConfig
public class AssistantResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void updatePhone(){

        Assistant assistant = this.webTestClient
                .get()
                .uri(AssistantResource.ASSISTANTS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Assistant.class)
                .value(Assertions::assertNotNull)
                .returnResult()
                .getResponseBody()
                .get(0);
        AssistantItem assistantPhone = new AssistantItem(123456789);
                this.webTestClient
                        .put()
                        .uri(AssistantResource.ASSISTANTS + AssistantResource.ID_ID + AssistantResource.PHONE, assistant.getId())
                        .body(BodyInserters.fromValue(assistantPhone))
                        .exchange()
                        .expectStatus().isOk()
                        .expectBody(Assistant.class)
                        .value(Assertions::assertNotNull);
    }
}
