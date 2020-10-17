package es.upm.miw.apaw_practice.adapters.rest.ticketbus;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.ticketbus.PassengerBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(PassengerBusResource.PASSENGERS_BUS)
public class PassengerBusResource {

    static final String PASSENGERS_BUS = "/ticketbus/passengers";
    static final String SEARCH = "/search";

    private PassengerBusService passengerBusService;

    @Autowired
    public PassengerBusResource(PassengerBusService passengerBusService) {
        this.passengerBusService = passengerBusService;
    }

    @GetMapping(SEARCH)
    public Stream<String> findIdJourneysFromNamePassenger(@RequestParam String q) {
        String namePassenger = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.passengerBusService.findIdJourneysFromNamePassenger(namePassenger);
    }
}
