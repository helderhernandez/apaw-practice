package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class FilmMakerEntityRepositoryIT {

    @Autowired
    private FilmMakerRepository filmMakerRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.filmMakerRepository.findAll().stream()
                .anyMatch(filmMaker ->
                        "filmMaker4".equals(filmMaker.getReference()) &&
                                "Steven Baker".equals(filmMaker.getName()) &&
                                LocalDate.of(1960, 4, 28).equals(filmMaker.getBirthday()) &&
                                "M".equals(filmMaker.getGender()))
        );
    }
}
