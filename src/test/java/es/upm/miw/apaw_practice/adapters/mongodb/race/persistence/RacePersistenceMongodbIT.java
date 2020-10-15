package es.upm.miw.apaw_practice.adapters.mongodb.race.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.race.Race;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class RacePersistenceMongodbIT {

    @Autowired
    private RacePersistenceMongodb racePersistenceMongodb;

    @Test
    void testReadById() {
        Race race = racePersistenceMongodb.readById("1");
        assertEquals("1", race.getId());
        assertEquals("Madrid", race.getLocation());
        assertEquals("Madrid Running Race", race.getName());
    }

    @Test
    void testReadByIdNotFound() {
        assertThrows(NotFoundException.class, () -> racePersistenceMongodb.readById("-1"));
    }

    @Test
    void testUpdateAndRead() {
        racePersistenceMongodb.updateLocation("2", "Guadalajara");
        Race race = racePersistenceMongodb.readById("2");
        assertEquals("2", race.getId());
        assertEquals("Guadalajara", race.getLocation());
    }
}
