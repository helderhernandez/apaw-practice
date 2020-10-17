package es.upm.miw.apaw_practice.domain.persistence_ports.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Court;
import es.upm.miw.apaw_practice.domain.models.basketball.CourtCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtPersistence {
    Court updateCapacity(Court court);

    Court create(CourtCreation courtCreation);
}
