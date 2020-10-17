package es.upm.miw.apaw_practice.domain.services.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Accident;
import es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes.AccidentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class AccidentService {

    private AccidentPersistence accidentPersistence;

    @Autowired
    public AccidentService(AccidentPersistence accidentPersistence) {
        this.accidentPersistence = accidentPersistence;
    }

    public Accident read(String id) {
        return this.accidentPersistence.readById(id);
    }

    public Accident updatePlace(Accident accident) {
        return this.accidentPersistence.updatePlace(accident);
    }

    public Stream<Accident> findRefAccidentsByNameOwner(String nameOwnerCar) {
        return this.accidentPersistence.findRefAccidentsByNameOwner(nameOwnerCar);
    }
}
