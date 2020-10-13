package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.models.school.StudentEmailUpdating;
import es.upm.miw.apaw_practice.domain.services.school.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(StudentResource.STUDENTS)
public class StudentResource {
    static final String STUDENTS = "/school/students";

    static final String SEARCH = "/search";
    static final String ID_ID = "/{id}";

    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Stream<Student> readAll() {
        return this.studentService.readAll();
    }

    @PatchMapping
    public void updateGraduations(@RequestBody List<StudentEmailUpdating> studentEmailUpdatingList) {
        this.studentService.updateEmail(studentEmailUpdatingList);
    }

    @GetMapping(SEARCH)
    public Stream<Student> findGraduateStudentsByKnowledgeArea(@RequestParam String q) {
        String knowledgeArea = new LexicalAnalyzer().extractWithAssure(q, "knowledgeArea");
        return this.studentService.findGraduateStudentsByKnowledgeArea(knowledgeArea);
    }

}
