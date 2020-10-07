package es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre;

import org.springframework.stereotype.Repository;

@Repository
public interface SessionPersistence {
    void deleteById(String id);
}
