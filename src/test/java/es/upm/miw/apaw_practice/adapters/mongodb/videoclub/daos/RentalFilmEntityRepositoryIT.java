package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class RentalFilmEntityRepositoryIT {

    @Autowired
    private RentalFilmRepository rentalFilmRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.rentalFilmRepository.findAll().stream()
                .anyMatch(rentalFilm ->
                        "2222".equals(rentalFilm.getReference()) &&
                                "The Pink Panther".equals(rentalFilm.getTitle()) &&
                                "1980".equals(rentalFilm.getYear().toString()) &&
                                "William Blake Crump".equals(rentalFilm.getFilmMaker().getName()) &&
                                (rentalFilm.getCategories().size()) == 2)
        );
    }
}
