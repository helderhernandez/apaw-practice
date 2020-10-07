package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos.SessionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.AssistantEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SessionEntity;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre.SessionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("sessionPersistence")
public class SessionPersistenceMongodb implements SessionPersistence {

    private SessionRepository sessionRepository;

    @Autowired
    public SessionPersistenceMongodb(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void deleteById(String id) {
        this.sessionRepository.deleteById(id);
    }

    @Override
    public Stream<String> findNameAssistantsSessionByInstructor(String nameInstructor) {
        return this.sessionRepository.findAll().stream()
                .filter(session -> session.getInstructor().getName().equals(nameInstructor))
                .flatMap(session -> session.getAssistants().stream())
                .map(AssistantEntity::getName);
    }
}
