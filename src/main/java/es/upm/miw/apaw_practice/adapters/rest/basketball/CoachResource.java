package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.domain.models.basketball.Coach;
import es.upm.miw.apaw_practice.domain.models.basketball.CoachCreation;
import es.upm.miw.apaw_practice.domain.services.basketball.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CoachResource.COACHS)
public class CoachResource {
    static final String COACHS = "/basketball/coachs";

    private CoachService coachService;

    @Autowired
    public CoachResource(CoachService coachService) {
        this.coachService = coachService;
    }

    @PostMapping
    public Coach create(@RequestBody CoachCreation coachCreation){
        return this.coachService.create(coachCreation);
    }
}
