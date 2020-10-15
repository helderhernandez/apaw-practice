package es.upm.miw.apaw_practice.adapters.rest.race;

import es.upm.miw.apaw_practice.domain.models.race.RunnerClub;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClubCreation;
import es.upm.miw.apaw_practice.domain.services.race.RunnerClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RunnerClubResource.RUNNER_CLUBS)
public class RunnerClubResource {

    static final String RUNNER_CLUBS = "/race/runner-clubs";

    private RunnerClubService runnerClubService;

    @Autowired
    public RunnerClubResource(RunnerClubService runnerClubService) {
        this.runnerClubService = runnerClubService;
    }

    @PostMapping
    public RunnerClub create(@RequestBody RunnerClubCreation runnerClubCreation) {
        return this.runnerClubService.create(runnerClubCreation);
    }

}
