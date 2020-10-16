package es.upm.miw.apaw_practice.domain.persistence_ports.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Coach;
import es.upm.miw.apaw_practice.domain.models.basketball.CoachCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachPersistence {
    Coach create(CoachCreation coachCreation);
    Coach readByDni(String dni);
}
