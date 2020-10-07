package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.PassengerRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.airport.PassengerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("passengerPersistence")
public class PassengerPersistenceMongodb implements PassengerPersistence {

    private PassengerRepository passengerRepository;

    @Autowired
    public PassengerPersistenceMongodb(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public void delete(String id) {
        this.passengerRepository.deleteById(id);
    }
}
