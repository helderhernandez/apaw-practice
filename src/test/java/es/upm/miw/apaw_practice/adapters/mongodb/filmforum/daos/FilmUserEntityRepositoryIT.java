package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class FilmUserEntityRepositoryIT {

    @Autowired
    private FilmUserRepository userRepository;

    @Test
    void testFindByUsernameFindUser() {
        Optional<FilmUserEntity> user = userRepository.findByUsername("mmonforte");
        assertTrue(user.isPresent());
    }

    @Test
    void testFindByUsernameDontFindUser() {
        Optional<FilmUserEntity> user = userRepository.findByUsername("user_not_exist");
        assertFalse(user.isPresent());
    }
}
