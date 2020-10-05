package es.upm.miw.apaw_practice.domain.services.school;

import es.upm.miw.apaw_practice.domain.models.school.Teacher;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.TeacherPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherPersistence teacherPersistence;

    @Autowired
    public TeacherService(TeacherPersistence teacherPersistence) {
        this.teacherPersistence = teacherPersistence;
    }

    public Teacher create(Teacher teacher) {
        return this.teacherPersistence.create(teacher);
    }
}
