package es.upm.miw.apaw_practice.adapters.rest.transport;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.transport.Worker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.transport.WorkerResource.DNI_DNI;
import static es.upm.miw.apaw_practice.adapters.rest.transport.WorkerResource.WORKERS;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class WorkerResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(WORKERS + DNI_DNI, "dni1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Worker.class)
                .value(Assertions::assertNotNull)
                .value(workerData -> {
                    assertEquals("name1", workerData.getName());
                    assertEquals("telephone1", workerData.getTelephone());
                    assertEquals(1, workerData.getExtraEntities().get(0).getWorkedHours());
                    assertTrue(workerData.getExtraEntities().get(0).getPaid());
                });
    }
}
