package es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes;

import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPersistence {
    void deleteById (String id);
}
