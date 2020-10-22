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
    void testCreateAndRead() {
        assertTrue(this.typeRepository.findAll().stream()
                .anyMatch(type ->
                        type.getId() != null &&
                                "Tragedy".equals(type.getName())&&
                                "Make people sad".equals(type.getDescription())
                ));
    }

    @Test
    void testFindByName() {
        assertTrue(this.typeRepository.findByName("Tragedy").isPresent());
        TypeEntity type = this.typeRepository.findByName("Tragedy").get();
        assertEquals("Make people sad", type.getDescription());
    }

}
