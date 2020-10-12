package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.AccidentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.CarRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.AccidentEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Accident;
import es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes.AccidentPersistence;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("accidentPersistence")
public class AccidentPersistenceMongodb implements AccidentPersistence {

    private AccidentRepository accidentRepository;
    private CarRepository carRepository;

    @Autowired
    public AccidentPersistenceMongodb(AccidentRepository accidentRepository, CarRepository carRepository) {
        this.accidentRepository = accidentRepository;
        this.carRepository = carRepository;
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

    @Override
    public Stream<Accident> findRefAccidentsByNameOwner(String nameOwnerCar) {
        return refAccidentsByNameOwner(nameOwnerCar)
                .map(ref -> {
                    Accident a = new Accident();
                    a.setRefAccident(ref);
                    return a;
                });
    }

    public Stream<String> refAccidentsByNameOwner(String nameOwnerCar) {
        return carRepository.findAll()
                .stream()
                .peek(carEntity -> LogManager.getLogger(this.getClass()).info("carEntity owner: " + carEntity.getOwner()))
                .filter(carEntity -> nameOwnerCar.equalsIgnoreCase(carEntity.getOwner().getName()))
                .flatMap(carEntity -> carEntity.getAccidents().stream())
                .map(accidentEntity -> accidentEntity.toAccident().getRefAccident());
    }
}
