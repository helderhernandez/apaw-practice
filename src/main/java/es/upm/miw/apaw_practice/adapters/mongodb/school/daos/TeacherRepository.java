package es.upm.miw.apaw_practice.adapters.mongodb.school.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.TeacherEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeacherRepository extends MongoRepository<TeacherEntity, String> {
    Optional<TeacherEntity> findByDni(String dni);
}
