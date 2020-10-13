package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmComment;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


@TestConfig
public class FilmForumPersistenceMongodbIT {

    @Autowired
    private FilmForumPersistenceMongodb filmForumPersistence;

    @Test
    void testReadByNameNameNotFound() {
        assertThrows(NotFoundException.class, () -> filmForumPersistence.findByName("Name_Not_found"));
    }

    @Test
    void testReadByNameWhenNameIsBadFormatted() {
        assertThrows(NotFoundException.class, () -> filmForumPersistence.findByName(null));
    }

    @Test
    void testReadByNameNameFound() {
        assertDoesNotThrow(() -> filmForumPersistence.findByName("film1"));
    }

    @Test
    void testUpdate() {
        FilmForum film = filmForumPersistence.findByName("film4");
        film.setYear(2600);
        film.setForAllPublic(false);
        FilmForum updatedFilm = filmForumPersistence.update(film);
        assertEquals(updatedFilm.getName(), film.getName());
        assertEquals(updatedFilm.getYear(), 2600);
        assertEquals(updatedFilm.getForAllPublic(), false);
    }

    @Test
    void testGetFilmFromComment() {
        FilmForum film = filmForumPersistence.findByName("film1");
        FilmComment comment = film.getComments().get(0);
        FilmForum foundFilm = filmForumPersistence.getFilmFromComment(comment);
        assertEquals(film.getId(), foundFilm.getId());
    }

    @Test
    void testGetFilmFromCommentCommentNotAssociated() {
        assertThrows(NotFoundException.class, () -> filmForumPersistence.getFilmFromComment(new FilmComment("NE", null, null, null, null)));
    }
}
