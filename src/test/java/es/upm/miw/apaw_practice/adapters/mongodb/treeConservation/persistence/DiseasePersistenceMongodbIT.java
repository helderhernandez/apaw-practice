package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.treeConservation.Disease;
import es.upm.miw.apaw_practice.domain.models.treeConservation.DiseaseCreation;
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
                new DiseaseCreation("diseasePersistenceTest","This is a persistence test disease");
        this.diseasePersistenceMongodb.create(diseaseCreation);
        Disease diseaseTest = this.diseasePersistenceMongodb.readByName("diseasePersistenceTest");
        assertEquals("This is a persistence test disease", diseaseTest.getDescription());
        assertNotNull(diseaseTest.getId());
    }
}
