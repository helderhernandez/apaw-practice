package es.upm.miw.apaw_practice.adapters.mongodb.transport.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class VehicleEntityRepositoryIT {
    @Autowired
    private VehicleReopsitory vehicleReopsitory;

    @Test
    void testCreateAndRead() {
        assertTrue(this.vehicleReopsitory.findAll().stream()
                .anyMatch(vehicle ->
                        "brand1".equals(vehicle.getBrand()) &&
                                "model1".equals(vehicle.getModel()) &&
                                "plate1".equals(vehicle.getPlate()) &&
                                vehicle.getWorkerEntity().getName().equals("name1")));
    }
}
