package es.upm.miw.apaw_practice.adapters.rest.ticketbus;

import es.upm.miw.apaw_practice.domain.models.ticketbus.PassengerBusCreation;
import es.upm.miw.apaw_practice.domain.models.ticketbus.TicketBus;
import es.upm.miw.apaw_practice.domain.services.ticketbus.TicketBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(TicketBusResource.TICKETBUSES)
public class TicketBusResource {

    static final String TICKETBUSES = "/ticketbus/tickets/";
    static final String ID = "/{id}";
    static final String PASSENGER = "/passenger";

    private TicketBusService ticketBusService;

    @Autowired
    public TicketBusResource(TicketBusService ticketBusService) {
        this.ticketBusService = ticketBusService;
    }

    @PutMapping(path = ID + PASSENGER)
    public TicketBus update(@PathVariable("id") String idTicket, @RequestBody PassengerBusCreation passenger) {
        return ticketBusService.update(idTicket, passenger);
    }

    @DeleteMapping(path = ID)
    public void delete(@PathVariable("id") String idTicket) {
        this.ticketBusService.delete(idTicket);
    }

}
