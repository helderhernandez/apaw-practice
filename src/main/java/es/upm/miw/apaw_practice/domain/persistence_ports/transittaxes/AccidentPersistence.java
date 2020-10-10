package es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Accident;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentPersistence {

    Accident readById(String id);

    Accident updatePlace(Accident accident);
}
