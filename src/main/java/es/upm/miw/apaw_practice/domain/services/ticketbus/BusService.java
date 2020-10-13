package es.upm.miw.apaw_practice.domain.services.ticketbus;

import es.upm.miw.apaw_practice.domain.models.ticketbus.Bus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.BusCreation;
import es.upm.miw.apaw_practice.domain.models.ticketbus.BusTicketsDatesUpdate;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus.BusPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class BusService {

    private BusPersistence busPersistence;

    @Autowired
    public BusService(BusPersistence busPersistence) {
        this.busPersistence = busPersistence;
    }

    public Bus create(BusCreation busCreation) {
        return this.busPersistence.create(busCreation);
    }

    public Bus updateTicketsDates(BusTicketsDatesUpdate busTicketsDatesUpdate) {
        return this.busPersistence.updateTicketsDates(busTicketsDatesUpdate);
    }

    public List<Bus> findAll() {
        return this.busPersistence.findAll();
    }

    public Stream<String> findNamePassengersByReference(String reference) {
        return this.busPersistence.findNamePassengersByReference(reference);
    }
}
