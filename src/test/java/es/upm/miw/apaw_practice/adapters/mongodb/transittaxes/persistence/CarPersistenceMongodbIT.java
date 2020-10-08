package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.TransitTaxesSeederService;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class CarPersistenceMongodbIT {

    @Autowired
    private CarPersistenceMongodb carPersistenceMongodb;

    @Autowired
    private TransitTaxesSeederService transitTaxesSeederService;

    @Test
    void testUpdate() {
        Optional<Car> car = this.carPersistenceMongodb.readAll()
                .filter(veh -> "01".equals(veh.getId()))
                .findFirst();
        assertTrue(car.isPresent());
        assertEquals("SEAT", car.get().getBrand());
        Car car2 = this.carPersistenceMongodb.updateBrand("01", "TOYOTA");
        assertNotEquals("SEAT", car2.getBrand());
        assertEquals("TOYOTA", car2.getBrand());

        transitTaxesSeederService.deleteAll();
        transitTaxesSeederService.seedDatabase();
    }
}
