package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.CourtRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.CourtEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.basketball.Court;
import es.upm.miw.apaw_practice.domain.persistence_ports.basketball.CourtPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("courtPersistence")
public class CourtPersistenceMongodb implements CourtPersistence {

    private CourtRepository courtRepository;

    @Autowired
    public CourtPersistenceMongodb(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    @Override
    public Court updateCapacity(String id, Integer capacity) {
        CourtEntity courtEntity = this.courtRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Court id: " + id));
        courtEntity.setCapacity(capacity);
        return this.courtRepository.save(courtEntity).toCourt();
    }
}
