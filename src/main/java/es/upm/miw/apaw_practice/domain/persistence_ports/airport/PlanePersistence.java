package es.upm.miw.apaw_practice.domain.persistence_ports.airport;

import es.upm.miw.apaw_practice.domain.models.airport.Plane;
import es.upm.miw.apaw_practice.domain.models.airport.PlaneCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanePersistence {

    Plane create(PlaneCreation planeCreation);
}
