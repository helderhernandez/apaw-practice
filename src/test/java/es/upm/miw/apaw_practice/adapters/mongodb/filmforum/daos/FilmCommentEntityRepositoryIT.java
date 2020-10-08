package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmCommentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class FilmCommentEntityRepositoryIT {

    @Autowired
    private FilmCommentRepository commentRepository;

    @Test
    void testFindByPunctuation() {
        Optional<List<FilmCommentEntity>> byPunctuation = commentRepository.findByPunctuation(60);
        assertTrue(byPunctuation.isPresent());
        assertEquals(1, byPunctuation.get().size());
    }

    @Test
    void testFindByCreatedAt() {
        Optional<List<FilmCommentEntity>> byCreatedAt = commentRepository.findByCreatedAt(LocalDateTime.of( 2020, 10, 7, 19, 0));
        assertTrue(byCreatedAt.isPresent());
        assertEquals(byCreatedAt.get().size(), 1);
    }
}
