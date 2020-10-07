package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.FlightRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.FlightEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.persistence_ports.airport.FlightPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("flightPersistence")
public class FlightPersistenceMongodb implements FlightPersistence {

    private FlightRepository flightRepository;

    @Autowired
    public FlightPersistenceMongodb(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Stream<Flight> readAll() {
        return flightRepository.findAll().stream()
                .map(FlightEntity::toFlight);
    }

    @Override
    public Flight readById(String id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Flight id: " + id))
                .toFlight();
    }

    @Override
    public Flight update(Flight flight) {
        FlightEntity flightEntity = flightRepository.findById(flight.getId())
                .orElseThrow(() -> new NotFoundException("Flight id: " + flight.getId()));
        flightEntity.fromFlight(flight);
        return this.flightRepository
                .save(flightEntity)
                .toFlight();
    }
}
