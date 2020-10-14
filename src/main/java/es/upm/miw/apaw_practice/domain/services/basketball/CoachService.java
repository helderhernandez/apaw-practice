package es.upm.miw.apaw_practice.domain.services.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Coach;
import es.upm.miw.apaw_practice.domain.models.basketball.CoachCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.CoachPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachService {

    private CoachPersistence coachPersistence;

    @Autowired
    public CoachService(CoachPersistence coachPersistence) {
        this.coachPersistence = coachPersistence;
    }


    public Coach create(CoachCreation coachCreation) {
        return this.coachPersistence.create(coachCreation);
    }
}
