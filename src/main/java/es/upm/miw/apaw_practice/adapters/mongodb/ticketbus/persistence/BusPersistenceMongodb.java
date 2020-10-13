package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.BusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.TicketBusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.BusEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.TicketBusEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.ticketbus.Bus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.BusCreation;
import es.upm.miw.apaw_practice.domain.models.ticketbus.BusTicketsDatesUpdate;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus.BusPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("busPersistence")
public class BusPersistenceMongodb implements BusPersistence {
    private static final String MSG_WITH_REFERENCE = "Bus with reference ";
    private static final String MSG_NOT_FOUND = " not found";

    private BusRepository busRepository;
    private TicketBusRepository ticketBusRepository;

    @Autowired
    public BusPersistenceMongodb(BusRepository busRepository,
                                 TicketBusRepository ticketBusRepository) {
        this.busRepository = busRepository;
        this.ticketBusRepository = ticketBusRepository;
    }

    @Override
    public List<Bus> findAll() {
        return this.busRepository.findAll().stream().map(BusEntity::toBus).collect(Collectors.toList());
    }

    @Override
    public Bus findByReference(String idReference) {
        return this.busRepository.findByReference(idReference)
                .orElseThrow(() -> new NotFoundException(MSG_WITH_REFERENCE + idReference + MSG_NOT_FOUND))
                .toBus();
    }

    @Override
    public Bus create(BusCreation busCreation) {

        List<TicketBusEntity> tickets = busCreation.getTickets().stream()
                .map(ticket -> this.ticketBusRepository.save(new TicketBusEntity(ticket)))
                .collect(Collectors.toList());

        BusEntity busEntity = new BusEntity(busCreation);
        busEntity.setTickets(tickets);

        return this.busRepository.save(busEntity).toBus();
    }

    @Override
    public Bus updateTicketsDates(BusTicketsDatesUpdate busTicketsDatesUpdate) {

        String idReference = busTicketsDatesUpdate.getReference();
        BusEntity bus = busRepository.findByReference(busTicketsDatesUpdate.getReference())
                .orElseThrow(() -> new NotFoundException(MSG_WITH_REFERENCE + idReference + MSG_NOT_FOUND));

        List<TicketBusEntity> ticketsUpdated = bus.getTickets().stream()
                .map(ticketBusEntity -> {
                    ticketBusEntity.setDates(busTicketsDatesUpdate.getDeparture(), busTicketsDatesUpdate.getArrive());
                    return this.ticketBusRepository.save(ticketBusEntity);
                }).collect(Collectors.toList());

        bus.setTickets(ticketsUpdated);

        return bus.toBus();
    }

    @Override
    public Stream<String> findNamePassengersByReference(String idReference) {

        BusEntity bus = busRepository.findByReference(idReference)
                .orElseThrow(() -> new NotFoundException(MSG_WITH_REFERENCE + idReference + MSG_NOT_FOUND));

        return bus.getTickets().stream()
                .map(ticketBusEntity -> ticketBusEntity.getPassenger().getName())
                .distinct();
    }
}
