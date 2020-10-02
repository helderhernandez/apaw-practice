package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.InstructorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SpecialityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class InstructorEntityRepositoryIT {

    @Autowired
    private InstructorRepository instructorRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.instructorRepository.findById("903").isPresent());
        InstructorEntity instructor = this.instructorRepository.findById("903").get();
        assertEquals("Javier", instructor.getName());
        assertEquals("Fernandez", instructor.getLastName());
        assertEquals(new BigDecimal(1200), instructor.getSalary());
        assertTrue(instructor.getSpecialities().stream()
            .map(SpecialityEntity::isRecomended)
            .collect(Collectors.toList())
            .containsAll(Arrays.asList(true, false, true)));
    }

}
