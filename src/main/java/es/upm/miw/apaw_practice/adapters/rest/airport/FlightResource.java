package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.services.airport.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(FlightResource.FLIGHTS)
public class FlightResource {
    static final String FLIGHTS = "/airport/flights";

    private FlightService flightService;

    @Autowired
    public FlightResource (FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public Stream<Flight> readAll() {
        return this.flightService.readAll();
    }
}
