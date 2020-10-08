package es.upm.miw.apaw_practice.adapters.rest.factory;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.hospital.BedResource;
import es.upm.miw.apaw_practice.adapters.rest.hospital.WidthDto;
import es.upm.miw.apaw_practice.domain.models.factory.Machine;
import es.upm.miw.apaw_practice.domain.models.factory.MachineItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void testFindMachineByEmployeeDegreeTitle(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(MachineResource.MACHINES + MachineResource.SEARCH)
                                .queryParam("q", "title:Grado en Ingeria de Telecomunicaciones")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Machine.class)
                .value(machines -> assertEquals("00000000A", machines.get(0).getEmployeeEntities().get(0).getDni()));
    }
}
