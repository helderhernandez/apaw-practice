package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.CourseRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.CoursePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
