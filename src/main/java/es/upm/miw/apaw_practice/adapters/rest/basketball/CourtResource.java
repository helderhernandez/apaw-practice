package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Court;
import es.upm.miw.apaw_practice.domain.services.basketball.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CourtResource.COURTS)
public class CourtResource {
    static final String COURTS = "/basketball/courts";
    static final String ID_ID = "/{id}";
    static final String CAPACITY = "/capacity";

    private CourtService courtService;

    @Autowired
    public CourtResource(CourtService courtService) {
        this.courtService = courtService;
    }

    @PutMapping(ID_ID + CAPACITY)
    public Court updateCapacity(@RequestBody Court court) {
        return this.courtService.updateCapacity(court);
    }

}
