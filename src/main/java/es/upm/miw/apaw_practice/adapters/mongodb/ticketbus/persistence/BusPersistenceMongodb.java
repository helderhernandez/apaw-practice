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

@Repository("busPersistence")
public class BusPersistenceMongodb implements BusPersistence {

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
                .orElseThrow(() -> new NotFoundException("Bus with reference: " + idReference + " not found"))
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
                .orElseThrow(() -> new NotFoundException("Bus with reference: " + idReference + " not found"));

        List<TicketBusEntity> ticketsUpdated = bus.getTickets().stream()
                .map(ticketBusEntity -> {
                    ticketBusEntity.setDates(busTicketsDatesUpdate.getDeparture(), busTicketsDatesUpdate.getArrive());
                    return this.ticketBusRepository.save(ticketBusEntity);
                }).collect(Collectors.toList());

        bus.setTickets(ticketsUpdated);

        return bus.toBus();
    }
}
