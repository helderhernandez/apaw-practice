package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmComment;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FilmCommentPersistenceMongodbIT {

    @Autowired
    private FilmCommentPersistenceMongodb filmCommentPersistence;

    @Autowired
    private FilmUserPersistenceMongodb filmUserPersistence;

    @Test
    void testDeleteByIdCommentNotFound() {
        assertThrows(NotFoundException.class, () -> filmCommentPersistence.delete("NOT_FOUND"));
    }

    @Test
    void testDeleteCommentSuccess() {
        assertDoesNotThrow(() -> filmCommentPersistence.delete("5"));
    }

    @Test
    void testFindCommentsByUser() {
        FilmUser filmUser = filmUserPersistence.findByUsername("acabezas");
        List<FilmComment> comments = filmCommentPersistence.findCommentsByUser(filmUser);
        assertEquals(comments.size(), 2);
    }

    @Test
    void testFindCommentByUserUserNotFound() {
        List<FilmComment> comments = filmCommentPersistence.findCommentsByUser(new FilmUser("Not_found", null, null));
        assertTrue(comments.isEmpty());
    }
}
