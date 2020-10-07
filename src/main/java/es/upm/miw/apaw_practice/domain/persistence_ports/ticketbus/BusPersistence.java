package es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus;

import es.upm.miw.apaw_practice.domain.models.ticketbus.Bus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.BusCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface BusPersistence {

    Bus create(BusCreation busCreation);
}
