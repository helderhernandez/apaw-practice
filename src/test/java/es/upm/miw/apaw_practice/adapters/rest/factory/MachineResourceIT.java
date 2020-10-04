package es.upm.miw.apaw_practice.adapters.rest.factory;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.factory.Machine;
import es.upm.miw.apaw_practice.domain.models.factory.MachineItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Objects;

@RestTestConfig
public class MachineResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(MachineResource.MACHINES)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Machine.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testUpdateStatus() {
        Machine machine = Objects.requireNonNull(this.webTestClient
                .get()
                .uri(MachineResource.MACHINES)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Machine.class)
                .value(Assertions::assertNotNull)
                .returnResult()
                .getResponseBody())
                .get(0);

        MachineItem machineItem = new MachineItem(true);
        this.webTestClient
                .put()
                .uri(MachineResource.MACHINES + MachineResource.ID_ID + MachineResource.STATUS, machine.getId())
                .body(BodyInserters.fromValue(machineItem))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Machine.class)
                .value(Assertions::assertNotNull);
    }

}
