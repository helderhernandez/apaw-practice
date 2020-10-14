package es.upm.miw.apaw_practice.adapters.mongodb.article.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.TypeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class TypeEntityRepositoryIT {

    @Autowired
    private TypeRepository typeRepository;

    @Test
    void testFindById() {
        assertTrue(this.typeRepository.findById("02").isPresent());
        TypeEntity type = this.typeRepository.findById("02").get();
        assertEquals("Make people sad", type.getDescription());
        assertEquals("Tragedy", type.getName());
    }

}
