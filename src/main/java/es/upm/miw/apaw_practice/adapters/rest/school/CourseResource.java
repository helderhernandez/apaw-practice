package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.domain.services.school.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
