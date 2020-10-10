package es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Owner;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPersistence {

    void deleteById(String id);

    Owner create(Owner owner);
}
