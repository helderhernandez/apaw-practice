package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.AccidentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.TaxEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.CarEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.composite.TreeCars;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.composite.TreeCarsComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.composite.TreeCarsLeaf;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testPatternComposite(){

        TreeCars carComposite1 = new TreeCarsComposite("BRAND FORD");
        TreeCars carComposite2 = new TreeCarsComposite("ZERO TRANSIT TAXES");
        TreeCars carComposite3= new TreeCarsComposite("BRAND SEAT");

        TreeCars carLeaf1 = new TreeCarsLeaf(this.carRepository.findByEnrollment("BBBB").get());
        carComposite1.add(carLeaf1);

        TreeCars carLeaf2 = new TreeCarsLeaf(this.carRepository.findByEnrollment("CCCC").get());
        TreeCars carLeaf3 = new TreeCarsLeaf(this.carRepository.findByEnrollment("DDDD").get());
        TreeCars carLeaf4 = new TreeCarsLeaf(this.carRepository.findByEnrollment("EEEE").get());
        carComposite2.add(carLeaf2);
        carComposite2.add(carLeaf3);
        carComposite2.add(carLeaf4);
        carComposite1.add(carComposite2);

        TreeCars carLeaf5 = new TreeCarsLeaf(this.carRepository.findByEnrollment("AAAA").get());
        carComposite3.add(carLeaf5);
        carComposite1.add(carComposite3);

        assertTrue(carComposite2.isComposite());
        assertFalse(carLeaf1.isComposite());

        assertEquals("BRAND FORD",carComposite1.enrollment());
        assertEquals("BRAND FORD",carComposite1.enrollment());

        assertEquals("ZERO TRANSIT TAXES",carComposite2.enrollment());
        assertEquals("BBBB",carLeaf1.enrollment());
        assertEquals("EEEE",carLeaf4.enrollment());
        assertEquals("AAAA",carLeaf5.enrollment());




    }
}
