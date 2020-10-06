package es.upm.miw.apaw_practice.adapters.mongodb.project.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.project.daos.DeveloperRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.DeveloperEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class DeveloperPersistenceMongodbIT {

    @Autowired
    private DeveloperPersistenceMongodb developerPersistence;
    @Autowired
    private DeveloperRepository developerRepository;

    @Test
    void updateYearsOfExperience() {
        assertTrue(this.developerRepository.findByEmail("jaime@developer.com").isPresent());
        DeveloperEntity developer = this.developerRepository.findByEmail("jaime@developer.com").get();
        assertEquals(10,
                this.developerPersistence.updateYearsOfExperience(developer.getId(), 10).getYearsOfExperience());
    }

}
