package es.upm.miw.apaw_practice.domain.services.airport;

import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import es.upm.miw.apaw_practice.domain.persistence_ports.airport.PassengerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PassengerService {

    private PassengerPersistence passengerPersistence;

    @Autowired
    public PassengerService(PassengerPersistence passengerPersistence) {
        this.passengerPersistence = passengerPersistence;
    }

    public void delete(String id) {
        passengerPersistence.delete(id);
    }

    public Stream<Passenger> findDistinctNameUserByModelPlane(String modelPlane) {
        return passengerPersistence.findDistinctNameUserByModelPlane(modelPlane);
    }
}
