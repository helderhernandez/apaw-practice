package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.StudentRepository;
import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.StudentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("studentPersistence")
public class StudentPersistenceMongodb implements StudentPersistence {
    private StudentRepository studentRepository;

    @Autowired
    public StudentPersistenceMongodb(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Stream<Student> readAll() {
        return this.studentRepository.findAll().stream()
                .map(studentEntity -> studentEntity.toStudent());
    }
}
