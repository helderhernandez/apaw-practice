package es.upm.miw.apaw_practice.domain.persistence_ports.school;

import es.upm.miw.apaw_practice.domain.models.school.Course;

import java.util.stream.Stream;

public interface CoursePersistence {
    void deleteById(String id);
    Stream<Course> findCoursesByTeacherName(String name);
}
