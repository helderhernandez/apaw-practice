package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.videoclub.FilmMaker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class FilmMakerPersistenceMongodbIT {

    @Autowired
    private FilmMakerPersistenceMongodb filmMakerPersistenceMongodb;

    @Test
    void testCreateAndRead() {
        FilmMaker filmMaker =
                new FilmMaker("filmMaker6", "James Cameron",
                        LocalDate.of(1955, 1, 31), "M");
        filmMakerPersistenceMongodb.create(filmMaker);
        FilmMaker filmMakerDB = filmMakerPersistenceMongodb.readByReference("filmMaker6");
        assertEquals("James Cameron", filmMakerDB.getName());
        assertEquals(LocalDate.of(1955, 1, 31), filmMakerDB.getBirthday());
        assertEquals("M", filmMakerDB.getGender());
    }
}
