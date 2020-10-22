package es.upm.miw.apaw_practice.domain.services.filmforum;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForumUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmForumPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@TestConfig
public class FilmForumServiceIT {
    @Autowired
    private FilmForumPersistence filmForumPersistence;

    @Autowired
    private FilmForumService filmForumService;

    @Test
    void testUpdateFilmAudience() {
        List<FilmForumUpdating> filmsToUpdate = List.of(new FilmForumUpdating("film3", false),
                new FilmForumUpdating("film4", false));
        filmForumService.updateFilmAudienceRange(filmsToUpdate);
        assertFalse(filmForumPersistence.findByName("film3").getForAllPublic());
        assertFalse(filmForumPersistence.findByName("film4").getForAllPublic());
        List<FilmForumUpdating> restoredFilms = List.of(new FilmForumUpdating("film3", false),
                new FilmForumUpdating("film4", false));
        filmForumService.updateFilmAudienceRange(restoredFilms);
    }
}