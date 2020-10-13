package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.models.airport.FlightPriceUpdating;
import es.upm.miw.apaw_practice.domain.services.airport.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(FlightResource.FLIGHTS)
public class FlightResource {

    static final String FLIGHTS = "/airport/flights";
    static final String SEARCH = "/search";

    private FlightService flightService;

    @Autowired
    public FlightResource (FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public Stream<Flight> readAll() {
        return this.flightService.readAll();
    }

    @PatchMapping
    public void updatePrices(@RequestBody List<FlightPriceUpdating> flightPriceUpdatingList) {
        this.flightService.updatePrices(flightPriceUpdatingList);
    }

    @GetMapping(SEARCH)
    public PriceDto findPriceBySuitcaseColor(@RequestParam String q) {
        String color = new LexicalAnalyzer().extractWithAssure(q, "color");
        return new PriceDto(this.flightService.findPriceBySuitcaseColor(color));
    }
}
