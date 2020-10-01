package es.upm.miw.apaw_practice.adapters.mongodb.school.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestConfig
public class StudentEntityRepositoryIT {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testFindByDni() {
        assertTrue(this.studentRepository.findByDni("49967689A").isPresent());
        StudentEntity student = this.studentRepository.findByDni("49967689A").get();
        assertEquals("vidalio@gmail.com", student.getEmail());
        assertEquals("Juan", student.getName());
        assertEquals("Vidal", student.getFamilyName());
        assertEquals(true, student.isGraduate());
    }
}