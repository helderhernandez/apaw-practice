package es.upm.miw.apaw_practice.adapters.rest.FurnitureFactory;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.WarehouseAreaUpdating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import java.util.Arrays;
import java.util.List;;



@RestTestConfig
class WarehouseResourceIT {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void testUpdateAreaNotFound() {
        List<WarehouseAreaUpdating> warehouseAreaUpdatingList = Arrays.asList(
                new WarehouseAreaUpdating("g", "1200m³")
        );
        this.webTestClient
                .patch()
                .uri(WarehouseResource.WAREHOUSES)
                .body(BodyInserters.fromValue(warehouseAreaUpdatingList))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void updateArea(){
        List<WarehouseAreaUpdating> warehouseAreaUpdatingList = Arrays.asList(
                new WarehouseAreaUpdating("a","1600m³"),
                new WarehouseAreaUpdating("b","1700m³"));
        this.webTestClient
                .patch()
                .uri(WarehouseResource.WAREHOUSES)
                .body(BodyInserters.fromValue(warehouseAreaUpdatingList))
                .exchange()
                .expectStatus().isOk();
    }
}
