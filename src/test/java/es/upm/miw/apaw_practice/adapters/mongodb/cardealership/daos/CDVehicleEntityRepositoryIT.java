package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class CDVehicleEntityRepositoryIT {
    @Autowired
    private CDVehicleRepository vehicleRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.vehicleRepository.findAll().stream()
                .anyMatch(vehicle ->
                        "Ford".equals(vehicle.getBrand()) &&
                                "Fiesta".equals(vehicle.getType()) &&
                                vehicle.getUnused() &&
                                vehicle.getYear() == 2014)
        );
    }
}
