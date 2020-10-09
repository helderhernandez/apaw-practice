package es.upm.miw.apaw_practice.domain.services.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Accident;
import es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes.AccidentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccidentService {

    private AccidentPersistence accidentPersistence;

    @Autowired
    public AccidentService(AccidentPersistence accidentPersistence) {
        this.accidentPersistence = accidentPersistence;
    }

    public Accident read(String id) {
        return this.accidentPersistence.read(id);
    }
}
