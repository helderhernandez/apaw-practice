package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtRestorerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ArtRestorerEntityRepositoryIT {

    @Autowired
    private ArtRestorerRepository artRestorerRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.artRestorerRepository.findById("ARR3").isPresent());
        ArtRestorerEntity artRestorer = this.artRestorerRepository.findById("ARR2").get();
        assertEquals("ARR2", artRestorer.getId());
        assertEquals("ArtRestorer2", artRestorer.getName());
        assertEquals("ArtRestorer_Surname2", artRestorer.getSurname());
        assertEquals("Title2", artRestorer.getJobTitle());
    }
}
