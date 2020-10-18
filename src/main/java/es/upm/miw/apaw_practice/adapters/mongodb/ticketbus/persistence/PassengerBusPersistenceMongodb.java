package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.BusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.PassengerBusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.TicketBusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.BusEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.JourneyEntity;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus.PassengerBusPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

@Repository("passengerBusPersistence")
public class PassengerBusPersistenceMongodb implements PassengerBusPersistence {

    private PassengerBusRepository passengerBusRepository;
    private TicketBusRepository ticketBusRepository;
    private BusRepository busRepository;

    @Autowired
    public PassengerBusPersistenceMongodb(PassengerBusRepository passengerBusRepository,
                                          TicketBusRepository ticketBusRepository,
                                          BusRepository busRepository){
        this.passengerBusRepository = passengerBusRepository;
        this.ticketBusRepository = ticketBusRepository;
        this.busRepository = busRepository;
    }

    @Override
    public Stream<String> findIdJourneysFromNamePassenger(String namePassenger) {

        return passengerBusRepository.findAllByName(namePassenger)
                .distinct()
                .map(passengerBusEntity -> ticketBusRepository.findAllByPassengerId(passengerBusEntity.getId()))
                .flatMap(Stream::distinct)
                .map(ticketBusEntity -> busRepository.findByTicketsIn(ticketBusEntity))
                .flatMap(Optional::stream)
                .distinct()
                .map(BusEntity::getJourneys)
                .flatMap(Collection::stream)
                .distinct()
                .map(JourneyEntity::getId);
    }
}
