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
    void testFindById() {
        assertTrue(this.authorRepository.findById("804").isPresent());
        AuthorEntity author = this.authorRepository.findById("804").get();
        assertEquals("Joaquín", author.getName());
        assertEquals("Arcángel", author.getSurname());
    }
}
