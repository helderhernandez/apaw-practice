package es.upm.miw.apaw_practice.adapters.mongodb.airport.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PlaneEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class PlaneRepositoryIT {

    @Autowired
    private PlaneRepository planeRepository;

    @Test
    void testFindAll() {
        List<PlaneEntity> planeEntityList = planeRepository.findAll();
        assertEquals(3, planeEntityList.size());
        assertEquals("11111", planeEntityList.get(0).getLicensePlate());
        assertEquals("11112", planeEntityList.get(1).getLicensePlate());
        assertEquals("11113", planeEntityList.get(2).getLicensePlate());
    }

    @Test
    void testFindByLicensePlate() {
        Optional<PlaneEntity> planeEntity = planeRepository.findByLicensePlate("11111");
        assertTrue(planeEntity.isPresent());
        assertEquals("model1", planeEntity.get().getModel());
    }

    @Test
     void testFindByLicensePlateEmpty() {
        Optional<PlaneEntity> planeEntity = planeRepository.findByLicensePlate("aaa");
        assertTrue(planeEntity.isEmpty());
    }
}