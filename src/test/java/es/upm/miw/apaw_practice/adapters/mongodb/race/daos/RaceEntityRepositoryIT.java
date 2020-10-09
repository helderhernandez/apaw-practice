package es.upm.miw.apaw_practice.adapters.mongodb.race.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RaceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class RaceEntityRepositoryIT {

    @Autowired
    private RaceRepository raceRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(raceRepository.findById("2").isPresent());
        RaceEntity race = raceRepository.findById("2").get();
        assertEquals("Barcelona", race.getLocation());
    }

}
