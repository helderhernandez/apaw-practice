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
                                "description2".equals(rentalFilm.getDescription()) &&
                                "1980".equals(rentalFilm.getYear().toString()) &&
                                "140".equals(rentalFilm.getDuration().toString()) &&
                                "William".equals(rentalFilm.getFilmMaker().getName()) &&
                                (rentalFilm.getCategories().size()) == 2)
        );
    }
}
