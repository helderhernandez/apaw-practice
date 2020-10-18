package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.CourtRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.CourtEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.basketball.Court;
import es.upm.miw.apaw_practice.domain.models.basketball.CourtCreation;
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
    public Court updateCapacity(Court court) {
        CourtEntity courtEntity = this.courtRepository.findById(court.getId())
                .orElseThrow(() -> new NotFoundException("Court id: " + court.getId()));
        courtEntity.setCapacity(court.getCapacity());
        return this.courtRepository.save(courtEntity).toCourt();
    }

    @Override
    public Court create(CourtCreation courtCreation) {
        return this.courtRepository.save(new CourtEntity(courtCreation)).toCourt();
    }
}
