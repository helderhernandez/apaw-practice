package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.AccidentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.AccidentEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Accident;
import es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes.AccidentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("accidentPersistence")
public class AccidentPersistenceMongodb implements AccidentPersistence {

    private AccidentRepository accidentRepository;

    @Autowired
    public AccidentPersistenceMongodb(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }
    @Override
    public Accident readById(String id) {
        return this.accidentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(" Accident id: " + id))
                .toAccident();
    }
    @Override
    public Accident updatePlace(Accident accident) {
        AccidentEntity accidentEntity = this.accidentRepository.findByRefAccident(accident.getRefAccident())
                .orElseThrow(() -> new NotFoundException(" Accident refAccident: " + accident.getRefAccident()));
        accidentEntity.setPlace(accident.getPlace());
        return this.accidentRepository.save(accidentEntity).toAccident();
    }
}
