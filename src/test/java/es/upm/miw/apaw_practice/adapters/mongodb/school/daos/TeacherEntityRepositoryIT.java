package es.upm.miw.apaw_practice.adapters.mongodb.school.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.TeacherEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class TeacherEntityRepositoryIT {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void testFindByDni() {
        assertTrue(this.teacherRepository.findByDni("33645788R").isPresent());
        TeacherEntity teacher = this.teacherRepository.findByDni("33645788R").get();
        assertEquals("teref@gmail.com", teacher.getEmail());
        assertEquals("Teresa", teacher.getName());
        assertEquals("Fridge", teacher.getFamilyName());
        assertEquals(true, teacher.isIntern());
    }
}
