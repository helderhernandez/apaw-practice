package es.upm.miw.apaw_practice.domain.services.sportcentre;

import es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre.SessionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private SessionPersistence sessionPersistence;

    @Autowired
    public SessionService(SessionPersistence sessionPersistence) {
        this.sessionPersistence = sessionPersistence;
    }

    public void delete(String id) {
        this.sessionPersistence.deleteById(id);
    }
}
