package es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus;

import es.upm.miw.apaw_practice.domain.models.ticketbus.PassengerBusCreation;
import es.upm.miw.apaw_practice.domain.models.ticketbus.TicketBus;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface TicketBusPersistence {

    Stream<TicketBus> findAll();
    TicketBus update(String idTicket, PassengerBusCreation passenger);
}
