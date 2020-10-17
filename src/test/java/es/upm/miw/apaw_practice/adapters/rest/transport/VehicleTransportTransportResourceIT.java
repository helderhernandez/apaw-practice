package es.upm.miw.apaw_practice.adapters.rest.transport;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.ExtraEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.WorkerEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.transport.VehicleTransport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;
import java.util.Arrays;

import static es.upm.miw.apaw_practice.adapters.rest.transport.VehicleTransportResource.SEARCH;
import static es.upm.miw.apaw_practice.adapters.rest.transport.VehicleTransportResource.VEHICLES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
class VehicleTransportTransportResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        ExtraEntity[] extras = {
                ExtraEntity.builder("1").workedHours(1).paid(true).build(),
                ExtraEntity.builder("2").workedHours(2).paid(false).build()
        };
        WorkerEntity worker = WorkerEntity.builder()
                .name("nameTest")
                .telephone("telephoneTest")
                .dni("dniTest")
                .extraEntities(Arrays.asList(extras[0], extras[1]))
                .build();
        VehicleTransport vehicleTransport =
                new VehicleTransport("brandTest", "modelTest", "plateTest", LocalDate.now(), worker);
        this.webTestClient
                .post()
                .uri(VEHICLES)
                .body(BodyInserters.fromValue(vehicleTransport))
                .exchange()
                .expectStatus().isOk()
                .expectBody(VehicleTransport.class)
                .value(Assertions::assertNotNull)
                .value(vehicleData -> assertNotNull(vehicleData.getId()));
    }

    @Test
    void testSearchModelDistinctbyDeptName() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(VEHICLES + SEARCH)
                                .queryParam("q", "name:name1")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(DistinctModelVehicleDto.class)
                .value(Assertions::assertNotNull)
                .value(DistinctModelVehicleDto -> assertEquals("model1", DistinctModelVehicleDto.get(0).getModel()))
                .value(DistinctModelVehicleDto -> assertEquals("model2", DistinctModelVehicleDto.get(1).getModel()));
    }
}
