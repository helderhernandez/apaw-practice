package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.AccidentRepository;
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
    public Accident read(String id) {

        return this.accidentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(" Accident id: " + id))
                .toAccident();

    }
}
