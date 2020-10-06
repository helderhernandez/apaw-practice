package es.upm.miw.apaw_practice.domain.services.school;

import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.models.school.StudentEmailUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.StudentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class StudentService {

    private final StudentPersistence studentPersistence;

    @Autowired
    public StudentService(StudentPersistence studentPersistence) {
        this.studentPersistence = studentPersistence;
    }

    public Stream<Student> readAll() {
        return this.studentPersistence.readAll();
    }

    public void updateEmail(List<StudentEmailUpdating> studentEmailUpdatingList) {
        studentEmailUpdatingList.stream()
                .map(studentNewEmail -> {
                    Student student = this.studentPersistence.readByDni(studentNewEmail.getDni());
                    student.setEmail(studentNewEmail.getEmail());
                    return student;
                })
                .forEach(student -> this.studentPersistence.update(student));
    }

    public Stream<Student> findGraduateStudentsByKnowledgeArea(String knowledgeArea) {
        return this.studentPersistence.findGraduateStudentsByKnowledgeArea(knowledgeArea);
    }
}
