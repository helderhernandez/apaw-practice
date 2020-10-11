package es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus;

import es.upm.miw.apaw_practice.domain.models.ticketbus.PassengerBusCreation;
import es.upm.miw.apaw_practice.domain.models.ticketbus.TicketBus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.TicketBusCreation;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface TicketBusPersistence {

    Stream<TicketBus> findAll();

    TicketBus update(String idTicket, PassengerBusCreation passenger);

    void delete(String reference);

    TicketBus save(TicketBusCreation ticketBusCreation);
}
