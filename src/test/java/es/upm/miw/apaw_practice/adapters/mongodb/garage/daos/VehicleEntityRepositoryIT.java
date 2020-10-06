package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.VehicleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VehicleEntityRepositoryIT {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    void testFindByCarRegistration() {
        assertTrue(this.vehicleRepository.findByCarRegistration("3584KXL").isPresent());
        VehicleEntity vehicle = this.vehicleRepository.findByCarRegistration("3584KXL").get();
        assertEquals("Seat", vehicle.getMake());
        assertEquals("Ibiza", vehicle.getModel());
        assertEquals(250.25, vehicle.getEstimatedBudget());
    }
}
