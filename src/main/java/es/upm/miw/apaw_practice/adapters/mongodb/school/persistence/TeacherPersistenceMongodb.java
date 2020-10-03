package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.TeacherRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.TeacherEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.school.Teacher;
import es.upm.miw.apaw_practice.domain.models.school.TeacherCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.TeacherPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("teacherPersistence")
public class TeacherPersistenceMongodb implements TeacherPersistence {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherPersistenceMongodb(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void assertDniNotExist(String dni) {
        this.teacherRepository
                .findByDni(dni)
                .ifPresent(article -> {
                    throw new ConflictException("Dni exist: " + dni);
                });
    }

    @Override
    public Teacher create(TeacherCreation teacherCreation) {
        this.assertDniNotExist(teacherCreation.getDni());
        return this.teacherRepository
                .save(new TeacherEntity(teacherCreation))
                .toTeacher();
    }
}
