package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.Disease;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.DiseaseCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class DiseasePersistenceMongodbIT {
    @Autowired
    private DiseasePersistenceMongodb diseasePersistenceMongodb;

    @Test
    void testReadByNameNotFound() {
        assertThrows(NotFoundException.class, () -> this.diseasePersistenceMongodb.readByName("fakeDisease"));
    }

    @Test
    void testCreateAndRead() {
        DiseaseCreation diseaseCreation =
                new DiseaseCreation("diseasePersistenceTest", "This is a persistence test disease");
        this.diseasePersistenceMongodb.create(diseaseCreation);
        Disease diseaseTest = this.diseasePersistenceMongodb.readByName("diseasePersistenceTest");
        assertEquals("This is a persistence test disease", diseaseTest.getDescription());
        assertNotNull(diseaseTest.getId());
    }
}
