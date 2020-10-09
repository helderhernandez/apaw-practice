package es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre;

import es.upm.miw.apaw_practice.domain.models.sportcentre.Instructor;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Session;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface SessionPersistence {
    void deleteById(String id);

    Stream<String> findNameAssistantsSessionByInstructor(String nameInstructor);

    Session findSessionByInstructor(Instructor instructor);
}
