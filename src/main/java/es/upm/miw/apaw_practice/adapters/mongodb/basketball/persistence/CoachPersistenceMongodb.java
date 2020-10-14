package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.CoachRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.CoachEntity;
import es.upm.miw.apaw_practice.domain.models.basketball.Coach;
import es.upm.miw.apaw_practice.domain.models.basketball.CoachCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.CoachPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("coachPersistence")
public class CoachPersistenceMongodb implements CoachPersistence {

    private CoachRepository coachRepository;

    @Autowired
    public CoachPersistenceMongodb(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public Coach create(CoachCreation coachCreation) {
        return this.coachRepository.save(new CoachEntity(coachCreation)).toCoach();
    }
}
