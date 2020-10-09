package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.VehicleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class CarEntityRepositoryIT {

    @Autowired
    private VehicleGarageRepository vehicleRepository;

    @Test
    void testFindByCarRegistration() {
        assertTrue(this.vehicleRepository.findByCarRegistration("4585LHS").isPresent());
        VehicleEntity vehicle = this.vehicleRepository.findByCarRegistration("4585LHS").get();
        assertEquals("Seat Ibiza", vehicle.getModel());
        assertEquals(0, BigDecimal.valueOf(250.25).compareTo(vehicle.getEstimatedBudget()));
        assertEquals(0, LocalDateTime.of(2020, 8, 2, 10, 0).compareTo(vehicle.getReceptionDate()));
        assertEquals(0, LocalDateTime.of(2020, 8, 20, 17, 30).compareTo(vehicle.getEstimatedDeliveryDate()));
        assertFalse(vehicle.getPieceEntities().isEmpty());
        assertFalse(vehicle.getMechanicEntities().isEmpty());
    }
}
