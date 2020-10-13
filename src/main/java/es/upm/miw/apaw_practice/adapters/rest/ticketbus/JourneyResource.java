package es.upm.miw.apaw_practice.adapters.rest.ticketbus;

import es.upm.miw.apaw_practice.domain.models.ticketbus.Journey;
import es.upm.miw.apaw_practice.domain.services.ticketbus.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(JourneyResource.JOURNEYS)
public class JourneyResource {
    static final String JOURNEYS = "/ticketbus/journeys";

    private JourneyService journeService;

    @Autowired
    public JourneyResource(JourneyService journeService) {
        this.journeService = journeService;
    }

    @GetMapping
    public Stream<Journey> findJourneys() {
        return this.journeService.findAll();
    }

}
