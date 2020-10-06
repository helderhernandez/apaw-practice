package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.VehicleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class VehicleEntityRepositoryIT {

    @Autowired
    private VehicleGarageRepository vehicleRepository;

    @Test
    void testFindByCarRegistration() {
        assertTrue(this.vehicleRepository.findByCarRegistration("4585LHS").isPresent());
        VehicleEntity vehicle = this.vehicleRepository.findByCarRegistration("4585LHS").get();
        assertEquals("Seat", vehicle.getMake());
        assertEquals("Ibiza", vehicle.getModel());
        assertEquals(0, BigDecimal.valueOf(250.25).compareTo(vehicle.getEstimatedBudget()));
    }
}
