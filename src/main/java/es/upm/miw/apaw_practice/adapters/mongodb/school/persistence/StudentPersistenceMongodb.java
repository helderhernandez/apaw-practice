package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.StudentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.StudentEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.StudentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("studentPersistence")
public class StudentPersistenceMongodb implements StudentPersistence {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentPersistenceMongodb(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Stream<Student> readAll() {
        return this.studentRepository.findAll().stream()
                .map(studentEntity -> studentEntity.toStudent());
    }

    @Override
    public Student update(Student student) {
        StudentEntity studentEntity = this.studentRepository
                .findById(student.getId())
                .orElseThrow(() -> new NotFoundException("Student id: " + student.getId()));
        studentEntity.fromStudent(student);
        return this.studentRepository
                .save(studentEntity)
                .toStudent();
    }

    @Override
    public Student readByDni(String dni) {
        return this.studentRepository
                .findByDni(dni)
                .orElseThrow(() -> new NotFoundException("Student dni: " + dni))
                .toStudent();
    }
}
