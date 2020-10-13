package es.upm.miw.apaw_practice.adapters.mongodb.article.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.EssayEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class EssayEntityRepositoryIT {

    @Autowired
    private EssayRepository essayRepository;

    @Test
    void testFindById() {
        assertTrue(this.essayRepository.findById("9801").isPresent());
        EssayEntity essay = this.essayRepository.findById("9801").get();
        assertEquals("Articlesgreen", essay.getName());
    }
}
