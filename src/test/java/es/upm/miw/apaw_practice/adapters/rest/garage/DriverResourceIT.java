package es.upm.miw.apaw_practice.adapters.rest.garage;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.daos.DriverRepository;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.garage.Driver;
import es.upm.miw.apaw_practice.domain.models.garage.DriverCreation;
import es.upm.miw.apaw_practice.domain.models.garage.VehicleCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class DriverResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private DriverRepository driverRepository;

    @Test
    void testCreate() {
        VehicleCreation vehicleCreation = new VehicleCreation("5846GBL", "Seat Arona FR eco TSI 1.2", BigDecimal.valueOf(750), LocalDateTime.now(), LocalDateTime.of(2020,11,20, 15, 00));
        DriverCreation driverCreation = new DriverCreation("45875214G", "Homer Simpson", "78854125", "h.simpson@exmaple.com", Boolean.TRUE, List.of(vehicleCreation));

        this.webTestClient
                    .post()
                    .uri(DriverResource.DRIVERS)
                    .body(BodyInserters.fromValue(driverCreation))
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody(Driver.class)
                    .value(Assertions::assertNotNull)
                    .value(vehicleData -> assertNotNull(vehicleData.getId()));
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(DriverResource.DRIVERS + DriverResource.ID_DNI, "12345678M")
                .exchange()
                .expectStatus().isOk();

        assertFalse(this.driverRepository.findByDni("12345678M").isPresent());
        assertTrue(this.driverRepository.findByDni("87654321K").isPresent());
        assertTrue(this.driverRepository.findByDni("28903000J").isPresent());
    }

}
