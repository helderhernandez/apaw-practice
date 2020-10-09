package es.upm.miw.apaw_practice.domain.services.sportcentre;

import es.upm.miw.apaw_practice.domain.models.sportcentre.BasicSession;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Instructor;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre.InstructorPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre.SessionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class SessionService {

    private SessionPersistence sessionPersistence;
    private InstructorPersistence instructorPersistence;

    @Autowired
    public SessionService(SessionPersistence sessionPersistence, InstructorPersistence instructorPersistence) {
        this.sessionPersistence = sessionPersistence;
        this.instructorPersistence = instructorPersistence;
    }

    public void delete(String id) {
        this.sessionPersistence.deleteById(id);
    }

    public Stream<String> findNameAssistantsSessionByInstructor(String nameInstructor) {
        return this.sessionPersistence.findNameAssistantsSessionByInstructor(nameInstructor);
    }

    public BasicSession findSessionBySpecialityTitle(String title) {
        Instructor instructor = this.instructorPersistence.readBySpecialityTitle(title);
        return this.sessionPersistence.findSessionByInstructor(instructor).toBasicSession();
    }
}
