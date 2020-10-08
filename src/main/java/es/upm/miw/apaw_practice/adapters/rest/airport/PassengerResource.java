package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.airport.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(PassengerResource.PASSENGERS)
public class PassengerResource {

    static final String PASSENGERS = "/airport/passengers";
    static final String ID = "/{id}";
    static final String SEARCH = "/search";

    private PassengerService passengerService;

    @Autowired
    public PassengerResource(PassengerService passengerService) {
        this.passengerService = passengerService;
    }


    @DeleteMapping(ID)
    public void delete(@PathVariable String id) {
        passengerService.delete(id);
    }

    @GetMapping(SEARCH)
    public Stream<PassengerNameDto> findDistinctNameUserByModelPlane(@RequestParam String q) {
        String model = new LexicalAnalyzer().extractWithAssure(q, "model");
        return this.passengerService.findDistinctNameUserByModelPlane(model)
                .map(PassengerNameDto::new);
    }
}
