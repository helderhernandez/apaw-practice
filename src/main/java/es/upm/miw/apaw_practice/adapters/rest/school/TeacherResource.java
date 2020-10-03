package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.domain.models.school.Teacher;
import es.upm.miw.apaw_practice.domain.models.school.TeacherCreation;
import es.upm.miw.apaw_practice.domain.services.school.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TeacherResource.TEACHERS)
public class TeacherResource {
    static final String TEACHERS = "/school/teachers";

    static final String SEARCH = "/search";

    private final TeacherService teacherService;

    @Autowired
    public TeacherResource(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public Teacher create(@RequestBody TeacherCreation teacherCreation) {
        return this.teacherService.create(teacherCreation);
    }
}
