package es.upm.miw.apaw_practice.adapters.mongodb.race.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RaceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class RaceEntityRepositoryIT {

    @Autowired
    private RaceRepository raceRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(raceRepository.findById("1").isPresent());
        RaceEntity race = raceRepository.findById("1").get();
        assertEquals("Madrid Running Race", race.getName());
    }

    @Test
    void testFindByName() {
        assertFalse(raceRepository.findByName("Madrid Running Race").isEmpty());
        List<RaceEntity> raceEntities = raceRepository.findByName("Madrid Running Race");
        RaceEntity raceEntity = raceEntities.get(0);
        assertEquals("Madrid Running Race", raceEntity.getName());
    }

    @Test
    void testFindByNameEmptyResult() {
        assertTrue(raceRepository.findByName("Tenerife Race").isEmpty());
    }

    @Test
    void testFindAll() {
        List<RaceEntity> raceEntities = raceRepository.findAll();
        assertEquals(3, raceEntities.size());
    }

}
