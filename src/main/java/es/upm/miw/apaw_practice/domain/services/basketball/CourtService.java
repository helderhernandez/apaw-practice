package es.upm.miw.apaw_practice.domain.services.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Court;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.CourtPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourtService {

    private CourtPersistence courtPersistence;

    @Autowired
    public CourtService(CourtPersistence courtPersistence) {
        this.courtPersistence = courtPersistence;
    }

    public Court updateCapacity(Court court) {
        return this.courtPersistence.updateCapacity(court);
    }

}
