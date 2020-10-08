package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.PassengerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PassengerEntity;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import es.upm.miw.apaw_practice.domain.persistence_ports.airport.PassengerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

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

    @Override
    public Stream<Passenger> findDistinctNameUserByModelPlane(String modelPlane) {
        return this.passengerRepository.findAll()
                .stream()
                .filter(passengerEntity -> passengerEntity.getFlightEntities()
                    .stream()
                    .anyMatch(flightEntity -> flightEntity.getPlaneEntity().getModel().equals(modelPlane)))
                .filter(distinctByKey(PassengerEntity::getName))
                .map(PassengerEntity::toPassenger);
    }

    private static <T> Predicate<T> distinctByKey(
            Function<? super T, ?> keyExtractor) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
