package es.upm.miw.apaw_practice.adapters.mongodb.article.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class EssayEntityRepositoryIT {

    @Autowired
    private EssayRepository essayRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.essayRepository.findAll().stream()
                .anyMatch(essay ->
                        essay.getId() !=null&&
                                "Articlesgreen".equals(essay.getName())&&
                                "72861".equals(essay.getId())


                ));
    }
}
