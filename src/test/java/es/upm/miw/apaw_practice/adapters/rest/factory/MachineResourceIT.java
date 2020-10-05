package es.upm.miw.apaw_practice.adapters.rest.factory;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.factory.MachineItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class MachineResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateStatus() {
        MachineItem machineItem = new MachineItem(true);
        this.webTestClient
                .put()
                .uri(MachineResource.MACHINES + MachineResource.ID_ID + MachineResource.STATUS, "notAnId")
                .body(BodyInserters.fromValue(machineItem))
                .exchange()
                .expectStatus().isNotFound();
    }

}
