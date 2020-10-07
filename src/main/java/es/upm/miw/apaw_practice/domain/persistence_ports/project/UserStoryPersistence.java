package es.upm.miw.apaw_practice.domain.persistence_ports.project;

import org.springframework.stereotype.Repository;

@Repository
public interface UserStoryPersistence {

    void delete(String id);

}
