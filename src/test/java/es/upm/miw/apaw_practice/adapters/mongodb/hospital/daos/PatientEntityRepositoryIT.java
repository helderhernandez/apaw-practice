package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.IllnessEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.PatientEntity;
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
        String [] symptomsA = { "Symptom A" };
        String [] causesA = { "Cause A" };
        List<IllnessEntity> illness = List.of(new IllnessEntity(3,symptomsA,causesA,true));
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
