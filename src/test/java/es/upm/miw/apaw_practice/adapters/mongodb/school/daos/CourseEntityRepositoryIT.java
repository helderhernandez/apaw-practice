package es.upm.miw.apaw_practice.adapters.mongodb.school.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class CourseEntityRepositoryIT {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.courseRepository.findAll().stream()
                .anyMatch(course ->
                        "Primary".equals(course.getAcademicLevel()) &&
                                "B".equals(course.getGroup()) &&
                                course.getId() != null &&
                                3 == course.getAcademicYear() &&
                                LocalDate.of(2020, 12, 3).equals(course.getStartDate()) &&
                                LocalDate.of(2023, 10, 17).equals(course.getFinishDate()) &&
                                4 == course.getSubjectEntities().size() &&
                                "Maths".equals(course.getSubjectEntities().get(0).getName()) &&
                                5 == course.getStudentEntities().size() &&
                                "Pepe".equals(course.getStudentEntities().get(0).getName())
                ));
    }
}
