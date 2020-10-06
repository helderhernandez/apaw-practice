package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.DriverEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class DriverEntityRepositoryIT {

    @Autowired
    private DriverRepository driverRepository;

    @Test
    void testFindByBarcode() {
        assertTrue(this.driverRepository.findByDni("87654321K").isPresent());
        DriverEntity driver = this.driverRepository.findByDni("87654321K").get();
        assertEquals("Francisco González", driver.getName());
        assertEquals("789456123", driver.getTelephone());
        assertEquals("frcgon@example.com", driver.getEmail());
        assertEquals(Boolean.FALSE, driver.getGarageMember());
        assertFalse(!driver.getVehicleEntities().isEmpty());
    }

}
