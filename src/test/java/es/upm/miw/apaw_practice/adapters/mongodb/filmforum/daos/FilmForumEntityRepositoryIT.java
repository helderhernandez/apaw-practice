package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmForumEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FilmForumEntityRepositoryIT {

    @Autowired
    private FilmForumRepository filmRepository;

    @Test
    void testFindByYear() {
        Optional<List<FilmForumEntity>> byYear = filmRepository.findByYear(2021);
        assertTrue(byYear.isPresent());
        assertEquals(byYear.get().size(), 2);
    }

    @Test
    void testFindByYearNoFilm() {
        Optional<List<FilmForumEntity>> byYear = filmRepository.findByYear(2050);
        assertTrue(byYear.isPresent());
        assertEquals(byYear.get().size(), 0);
    }
}
