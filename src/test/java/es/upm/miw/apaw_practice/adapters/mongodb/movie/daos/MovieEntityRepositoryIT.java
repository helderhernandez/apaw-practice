package es.upm.miw.apaw_practice.adapters.mongodb.movie.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.MovieEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class MovieEntityRepositoryIT {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void testFindByFilmTitle() {
        assertTrue(this.movieRepository.findByFilmTitle("Avengers").isPresent());
        MovieEntity movie = this.movieRepository.findByFilmTitle("Avengers").get();
        assertEquals("Hector Munoz Merida", movie.getFilmDirector().getName() + " " + movie.getFilmDirector().getFullName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        assertEquals(LocalDateTime.parse("2010-01-09 14:12",
                formatter).toString(), movie.getReleaseDate().toString());
        assertEquals("tttttttt", movie.getSynopsis());
        assertEquals(5, movie.getPunctuation());
    }
}
