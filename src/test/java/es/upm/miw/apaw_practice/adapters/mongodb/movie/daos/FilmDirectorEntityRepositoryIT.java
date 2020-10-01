package es.upm.miw.apaw_practice.adapters.mongodb.movie.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class FilmDirectorEntityRepositoryIT {

    @Autowired
    private FilmDirectorRepository filmDirectorRepository;

    @Test
    void testCreateAndRead(){
        assertTrue(this.filmDirectorRepository.findAll().stream()
                .anyMatch(filmDirector ->
                        filmDirector.getName().equals("Hector") &&
                                filmDirector.getFullName().equals("Munoz Merida") &&
                                filmDirector.getId() != null &&
                                filmDirector.getAge() == 22
                ));
    }
}
