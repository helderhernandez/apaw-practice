package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.BusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.TicketBusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.BusEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.TicketBusEntity;
import es.upm.miw.apaw_practice.domain.models.ticketbus.Bus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.BusCreation;
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
                                 TicketBusRepository ticketBusRepository){
        this.busRepository = busRepository;
        this.ticketBusRepository = ticketBusRepository;
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
}
