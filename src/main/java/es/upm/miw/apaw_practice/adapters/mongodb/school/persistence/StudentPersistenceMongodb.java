package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.CourseRepository;
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
    private final CourseRepository courseRepository;

    @Autowired
    public StudentPersistenceMongodb(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
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

    @Override
    public Stream<Student> findGraduateStudentsByKnowledgeArea(String knowledgeArea) {
        return this.courseRepository.findAll().stream()
                .map(courseEntity -> courseEntity.toCourse())
                .filter(course -> course.getSubjectEntities().stream()
                        .anyMatch(subjectEntity -> subjectEntity.getKnowledgeArea().equals(knowledgeArea)))
                .map(course -> course.getStudentEntities())
                .flatMap(studentEntities -> studentEntities.stream())
                .filter(studentEntity -> studentEntity.isGraduate() == true)
                .distinct()
                .map(studentEntity -> studentEntity.toStudent());
    }
}
