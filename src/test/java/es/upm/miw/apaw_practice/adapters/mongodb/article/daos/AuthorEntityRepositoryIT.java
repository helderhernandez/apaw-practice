package es.upm.miw.apaw_practice.adapters.mongodb.article.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestConfig
public class AuthorEntityRepositoryIT {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void testCreateAndRead() {

        assertTrue(this.authorRepository.findAll().stream()
                .anyMatch(author ->
                        author.getId() != null &&
                                "Juan".equals(author.getName()) &&
                                "Vidal".equals(author.getSurname()) &&
                                "America".equals(author.getNationality())

                ));
    }

    @Test
    void testCreateAuthorBuilder() {
        AuthorEntity authorEntity = new AuthorEntity.Builder()
                .name("Mario")
                .surname("Lee")
                .nationality("Japan").build();

        assertEquals("Mario", authorEntity.getName());
        assertEquals("Lee", authorEntity.getSurname());
        assertEquals("Japan", authorEntity.getNationality());
    }
}
