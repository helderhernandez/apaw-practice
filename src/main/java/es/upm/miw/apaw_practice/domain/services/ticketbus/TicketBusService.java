package es.upm.miw.apaw_practice.domain.services.ticketbus;

import es.upm.miw.apaw_practice.domain.models.ticketbus.PassengerBusCreation;
import es.upm.miw.apaw_practice.domain.models.ticketbus.TicketBus;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus.TicketBusPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBusService {

    private TicketBusPersistence ticketBusPersistence;

    @Autowired
    public TicketBusService(TicketBusPersistence ticketBusPersistence) {
        this.ticketBusPersistence = ticketBusPersistence;
    }

    public TicketBus update(String reference, PassengerBusCreation passenger) {
        return ticketBusPersistence.update(reference, passenger);
    }
}
