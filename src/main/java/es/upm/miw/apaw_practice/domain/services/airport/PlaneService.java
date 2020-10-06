package es.upm.miw.apaw_practice.domain.services.airport;

import es.upm.miw.apaw_practice.domain.models.airport.Plane;
import es.upm.miw.apaw_practice.domain.models.airport.PlaneCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.airport.PlanePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneService {

    private PlanePersistence planePersistence;

    @Autowired
    public PlaneService(PlanePersistence planePersistence) {
        this.planePersistence = planePersistence;
    }

    public Plane create(PlaneCreation planeCreation) {
        return planePersistence.create(planeCreation);
    }

    public Plane updateCapacity(String id, Integer capacity) {
        return planePersistence.updateCapacity(id, capacity);
    }
}
