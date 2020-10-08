package es.upm.miw.apaw_practice.domain.persistence_ports.airport;

import org.springframework.stereotype.Repository;

@Repository
public interface PassengerPersistence {

    void delete(String id);
}
