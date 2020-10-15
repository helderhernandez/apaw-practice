package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.DriverEntity;
import es.upm.miw.apaw_practice.domain.models.garage.Driver;
import es.upm.miw.apaw_practice.domain.models.garage.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
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
        assertFalse(driver.getVehicleEntities().isEmpty());
    }

    @Test
    void testDriverBuilder() {
        Driver driver = Driver.builder()
                .id("12345")
                .dni("54685214G")
                .name("Alberto")
                .telephone("924658999")
                .email("test@example.com")
                .garageMember(Boolean.TRUE)
                .vehicles(List.of(new Vehicle()))
                .build();

        assertNotNull(driver);

        assertEquals("12345", driver.getId());
        assertEquals("54685214G", driver.getDni());
        assertEquals("Alberto", driver.getName());
        assertEquals("924658999", driver.getTelephone());
        assertEquals("test@example.com", driver.getEmail());
        assertEquals(Boolean.TRUE, driver.getGarageMember());
        assertEquals(1, driver.getVehicles().size());
    }

}
