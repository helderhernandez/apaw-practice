package es.upm.miw.apaw_practice.domain.persistence_ports.school;

import es.upm.miw.apaw_practice.domain.models.school.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherPersistence {
    Teacher create(Teacher teacher);
}
