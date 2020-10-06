package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.CourseRepository;
import es.upm.miw.apaw_practice.domain.models.school.Course;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.CoursePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("coursePersistence")
public class CoursePersistenceMongodb implements CoursePersistence {
    private final CourseRepository courseRepository;

    @Autowired
    public CoursePersistenceMongodb(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void deleteById(String id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public Stream<Course> findCoursesByTeacherName(String name) {
        return this.courseRepository.findAll().stream().map(courseEntity -> courseEntity.toCourse())
                .filter(course -> course.getSubjectEntities().stream()
                        .map(subjectEntity -> subjectEntity.getTeacherEntity()
                                .getName()).anyMatch(nameTeacher -> nameTeacher.equals(name)));
    }
}

