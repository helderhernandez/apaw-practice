package es.upm.miw.apaw_practice.domain.services.ticketbus;

import es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus.PassengerBusPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PassengerBusService {

    private PassengerBusPersistence passengerBusPersistence;

    @Autowired
    public PassengerBusService(PassengerBusPersistence passengerBusPersistence) {
        this.passengerBusPersistence = passengerBusPersistence;
    }

    public Stream<String> findIdJourneysFromNamePassenger(String namePassenger) {
        return this.passengerBusPersistence.findIdJourneysFromNamePassenger(namePassenger);
    }
}
