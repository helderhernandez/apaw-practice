package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.AccidentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.TaxEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.CarEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class CarEntityRepositoryIT {

    @Autowired
    private CarRepository carRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.carRepository.findByEnrollment("AAAA").isPresent());
        CarEntity car = this.carRepository.findByEnrollment("AAAA").get();
        assertEquals("AAAA", car.getEnrollment());
        assertEquals("SEAT", car.getBrand());
        assertEquals("Maria", car.getOwner().getName());
        assertEquals("Perez", car.getOwner().getFamilyName());
        assertEquals("Toledo", car.getAccidents().get(0).getPlace());
        assertTrue(car.getAccidents().stream()
                .map(AccidentEntity::getRefAccident)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList("ACC001")));
        assertTrue(car.getTaxes().stream()
                .map(TaxEntity::getDescription)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList("Driving without a driver's license")));
    }
}
