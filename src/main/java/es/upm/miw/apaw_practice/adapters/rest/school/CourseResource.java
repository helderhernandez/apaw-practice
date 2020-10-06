package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.school.Course;
import es.upm.miw.apaw_practice.domain.services.school.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(CourseResource.COURSES)
public class CourseResource {
    static final String COURSES = "/school/courses";

    static final String ID_ID = "/{id}";
    static final String SEARCH = "/search";

    private final CourseService courseService;

    @Autowired
    public CourseResource(CourseService courseService) {
        this.courseService = courseService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.courseService.delete(id);
    }

    @GetMapping(SEARCH)
    public Stream<Course> findCoursesByTeacherName(@RequestParam String q) {
        String name = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.courseService.CoursesByTeacherName(name);
    }
}
