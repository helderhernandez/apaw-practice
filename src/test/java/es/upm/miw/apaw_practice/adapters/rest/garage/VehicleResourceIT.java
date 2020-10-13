package es.upm.miw.apaw_practice.adapters.rest.garage;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.garage.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class VehicleResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testUpdateEstimatedBudget(){
        List<VehicleEstimatedBudgetUpdating> vehicleEstimatedBudgetUpdating = Arrays.asList(
                new VehicleEstimatedBudgetUpdating("7777MKL", BigDecimal.valueOf(100)),
                new VehicleEstimatedBudgetUpdating("1111PLO", BigDecimal.valueOf(200))
        );

        this.webTestClient
                .patch()
                .uri(VehicleGarageResource.VEHICLES)
                .body(BodyInserters.fromValue(vehicleEstimatedBudgetUpdating))
                .exchange()
                .expectStatus().isOk();

        this.webTestClient
                .get()
                .uri(VehicleGarageResource.VEHICLES)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Vehicle.class)
                .consumeWith(entityList -> {
                    assertNotNull(entityList.getResponseBody());
                    entityList.getResponseBody().stream()
                            .filter(vehicle -> vehicle.getCarRegistration().equals("7777MKL"))
                            .peek(vehicle -> assertTrue(vehicle.getEstimatedBudget().equals(BigDecimal.valueOf(100))));;

                    entityList.getResponseBody().stream()
                            .filter(vehicle -> vehicle.getCarRegistration().equals("1111PLO"))
                            .peek(vehicle -> assertTrue(vehicle.getEstimatedBudget().equals(BigDecimal.valueOf(200))));
                });
    }
}
