package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.domain.models.airport.Plane;
import es.upm.miw.apaw_practice.domain.models.airport.PlaneCreation;
import es.upm.miw.apaw_practice.domain.services.airport.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PlaneResource.PLANES)
public class PlaneResource {

    static final String PLANES = "/airport/planes";

    private PlaneService planeService;

    @Autowired
    public PlaneResource(PlaneService planeService) {
        this.planeService = planeService;
    }

    @PostMapping
    public Plane create(@RequestBody PlaneCreation planeCreation) {
        return this.planeService.create(planeCreation);
    }
}
