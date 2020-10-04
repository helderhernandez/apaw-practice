package es.upm.miw.apaw_practice.adapters.mongodb.project.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.DeveloperEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class DeveloperEntityRepositoryIT {

    @Autowired
    private DeveloperRepository developerRepository;

    @Test
    void testFindByEmail() {
        assertTrue(this.developerRepository.findByEmail("jaime@developer.com").isPresent());
        DeveloperEntity developer = this.developerRepository.findByEmail("jaime@developer.com").get();
        assertEquals("Jaime", developer.getName());
        assertEquals("jaime@developer.com", developer.getEmail());
        assertEquals(7, developer.getYearsOfExperience());
    }

}
