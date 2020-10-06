package es.upm.miw.apaw_practice.adapters.rest.ticketbus;


import es.upm.miw.apaw_practice.domain.models.ticketbus.Bus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.BusCreation;
import es.upm.miw.apaw_practice.domain.services.ticketbus.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BusResource.BUSES)
public class BusResource {
    static final String BUSES = "/ticketbus/buses";


    private BusService busService;

    @Autowired
    public BusResource(BusService busService){
        this.busService = busService;
    }

    @PostMapping
    public Bus create(@RequestBody BusCreation busCreation) {
        return this.busService.create(busCreation);
    }
}
