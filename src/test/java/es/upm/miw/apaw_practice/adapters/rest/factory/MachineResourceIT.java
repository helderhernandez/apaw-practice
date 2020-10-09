package es.upm.miw.apaw_practice.adapters.rest.factory;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.factory.Machine;
import es.upm.miw.apaw_practice.domain.models.factory.MachineItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void testFindMachineByEmployeeDegreeTitle() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(MachineResource.MACHINES + MachineResource.SEARCH)
                                .queryParam("q", "title:Grado en Ingenieria Mecanica")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Machine.class)
                .value(machines -> assertEquals(800500L, machines.get(0).getSerialNumber()))
                .value(machines -> assertEquals("33333333D", machines.get(0).getEmployeeEntities().get(0).getDni()))
                .value(machines -> assertEquals(700500L, machines.get(1).getSerialNumber()))
                .value(machines -> assertEquals("66666666G", machines.get(1).getEmployeeEntities().get(0).getDni()))
                .value(machines -> assertEquals("77777777H", machines.get(1).getEmployeeEntities().get(1).getDni()));
    }

    @Test
    void testFindMachineByEmployeeDegreeTitleBadRequest() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(MachineResource.MACHINES + MachineResource.SEARCH)
                                .queryParam("q", "badRequest:Grado en Ingenieria Mecanica")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }
}
