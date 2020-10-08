package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmForumEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class FilmForumEntityRepositoryIT {

    @Autowired
    private FilmForumRepository filmRepository;

    @Test
    void testFindByYear() {
        List<FilmForumEntity> byYear = filmRepository.findByYear(2021);
        assertEquals(byYear.size(), 2);
    }

    @Test
    void testFindByYearNoFilm() {
        List<FilmForumEntity> byYear = filmRepository.findByYear(2050);
        assertEquals(byYear.size(), 0);
    }
}