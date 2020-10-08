package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmCommentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class FilmCommentEntityRepositoryIT {

    @Autowired
    private FilmCommentRepository commentRepository;

    @Test
    void testFindByPunctuation() {
        List<FilmCommentEntity> byPunctuation = commentRepository.findByPunctuation(60);
        assertEquals(1, byPunctuation.size());
    }

    @Test
    void testFindByCreatedAt() {
        List<FilmCommentEntity> byCreatedAt = commentRepository.findByCreatedAt(LocalDateTime.of(2020, 10, 7, 19, 0));
        assertEquals(byCreatedAt.size(), 1);
    }
}
