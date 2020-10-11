package es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus;

import es.upm.miw.apaw_practice.domain.models.ticketbus.Bus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.BusCreation;
import es.upm.miw.apaw_practice.domain.models.ticketbus.BusTicketsDatesUpdate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusPersistence {

    List<Bus> findAll();

    Bus findByReference(String reference);

    Bus create(BusCreation busCreation);

    Bus updateTicketsDates(BusTicketsDatesUpdate busTicketsDatesUpdate);
}
