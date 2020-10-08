package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.IllnessEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.PatientEntity;
import es.upm.miw.apaw_practice.domain.models.hospital.Illness;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class PatientEntityRepositoryIT {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void testFindByDni() {
        IllnessEntity illnessEntity = IllnessEntity.builder().phase(3).symptoms("Symptom A").endSymptoms().causes("Cause A").endCauses().contagious(true).build();
        List<IllnessEntity> illness = List.of(illnessEntity);
        String [] pathologiesA = {"pathologieA","pathlologieA2"};

        assertTrue(this.patientRepository.findByDni("11111111A").isPresent());
        PatientEntity patientEntity = this.patientRepository.findByDni("11111111A").get();
        assertEquals("NameA", patientEntity.getName());
        assertEquals("SurnameA", patientEntity.getSurname());
        assertEquals(pathologiesA[0],patientEntity.getPathologies()[0]);
        assertEquals(pathologiesA[1],patientEntity.getPathologies()[1]);
        assertEquals(illness.size(),patientEntity.getIllnessEntities().size());
    }
}
