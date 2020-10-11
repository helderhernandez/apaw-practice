package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.DiseaseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class DiseaseEntityRepositoryIT {
    @Autowired
    private DiseaseRepository diseaseRepository;

    @Test
    void testFindByName() {
        assertTrue(this.diseaseRepository.findByName("disease6").isEmpty());
        assertTrue(this.diseaseRepository.findByName("disease1").isPresent());
        DiseaseEntity disease = this.diseaseRepository.findByName("disease1").get();
        assertEquals("This is the disease1", disease.getDescription());
    }

}
