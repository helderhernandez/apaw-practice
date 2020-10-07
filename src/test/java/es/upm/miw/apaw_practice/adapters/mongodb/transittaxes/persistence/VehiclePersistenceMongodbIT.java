package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.TransitTaxesSeederService;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class VehiclePersistenceMongodbIT {

    @Autowired
    private VehiclePersistenceMongodb vehiclePersistenceMongodb;

    @Autowired
    private TransitTaxesSeederService transitTaxesSeederService;

    @Test
    void testUpdate() {
        Optional<Vehicle> vehicle = this.vehiclePersistenceMongodb.readAll()
                .filter(veh -> "01".equals(veh.getId()))
                .findFirst();
        assertTrue(vehicle.isPresent());
        assertEquals("SEAT", vehicle.get().getBrand());
        Vehicle vehicle2 = this.vehiclePersistenceMongodb.updateBrand("01", "TOYOTA");
        assertNotEquals("SEAT", vehicle2.getBrand());
        assertEquals("TOYOTA", vehicle2.getBrand());

        transitTaxesSeederService.deleteAll();
        transitTaxesSeederService.seedDatabase();
    }
}
