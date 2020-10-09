package es.upm.miw.apaw_practice.domain.services.school;

import es.upm.miw.apaw_practice.domain.models.school.Course;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.CoursePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class CourseService {
    private final CoursePersistence coursePersistence;

    @Autowired
    public CourseService(CoursePersistence coursePersistence) {
        this.coursePersistence = coursePersistence;
    }

    public void delete(String id) {
        this.coursePersistence.deleteById(id);
    }

    public Stream<Course> CoursesByTeacherName(String name) {
        return this.coursePersistence.findCoursesByTeacherName(name);
    }
}
