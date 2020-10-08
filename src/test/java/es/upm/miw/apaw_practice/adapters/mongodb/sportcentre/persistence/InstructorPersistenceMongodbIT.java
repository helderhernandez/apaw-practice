package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SpecialityEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistance.InstructorPersistenceMongodb;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Instructor;
import es.upm.miw.apaw_practice.domain.models.sportcentre.InstructorCreation;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Speciality;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class InstructorPersistenceMongodbIT {

    @Autowired
    private InstructorPersistenceMongodb instructorPersistence;


    @Test
    void testDniNotExist(){
        assertDoesNotThrow(() -> this.instructorPersistence.assertDniNotExist("999999999A"));
    }

    @Test
    void testCreate(){
        Speciality speciality = SpecialityEntity.builder().id("spec7").title("Padel").description("Padel training").duration(120).recomended(true).build().toSpeciality();
        InstructorCreation instructorCreation = new InstructorCreation("222222222A", "Eduardo", "Jimenez", new BigDecimal(1300), List.of(speciality));
        Instructor instructor = this.instructorPersistence.create(instructorCreation);
        assertEquals("222222222A", instructor.getDni());
        assertEquals("Eduardo", instructor.getName());
        assertEquals(1, instructor.getSpecialities().size());
    }

}
