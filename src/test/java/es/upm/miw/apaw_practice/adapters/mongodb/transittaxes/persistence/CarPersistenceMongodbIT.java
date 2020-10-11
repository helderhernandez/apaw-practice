package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class CarPersistenceMongodbIT {

    @Autowired
    private CarPersistenceMongodb carPersistenceMongodb;

    @Test
    void testUpdate() {
        Optional<Car> car = this.carPersistenceMongodb.readAll()
                .filter(veh -> "AAAA".equals(veh.getEnrollment()))
                .findFirst();
        assertTrue(car.isPresent());
        Car car2 = this.carPersistenceMongodb.updateBrand("01", "TOYOTA");
        assertNotEquals("SEAT", car2.getBrand());
        assertEquals("TOYOTA", car2.getBrand());
        assertEquals(List.of("ACC001"), car2.getRefAccidents());
        assertEquals(List.of("TAX001"), car2.getRefTaxes());
        assertEquals("00000000A", car2.getDniOwner());
        this.carPersistenceMongodb.updateBrand("01", "SEAT");
    }
}
