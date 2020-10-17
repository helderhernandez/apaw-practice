package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.videoclub.RentalFilm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class RentalFilmPersistenceMongodbIT {

    @Autowired
    private RentalFilmPersistenceMongodb rentalFilmPersistenceMongodb;

    @Test
    void testRead() {
        RentalFilm rentalFilm = rentalFilmPersistenceMongodb.read("4444");
        assertEquals("Generation Z", rentalFilm.getTitle());
        assertEquals("1998", rentalFilm.getYear().toString());
        assertEquals("filmMaker4", rentalFilm.getFilmMaker().getReference());
        assertEquals("cat4", rentalFilm.getCategories().get(0).getReference());
    }
}
