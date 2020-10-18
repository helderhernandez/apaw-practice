package es.upm.miw.apaw_practice.adapters.rest.race;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClub;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClubCreation;
import es.upm.miw.apaw_practice.domain.services.race.RunnerClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(RunnerClubResource.RUNNER_CLUBS)
public class RunnerClubResource {

    static final String RUNNER_CLUBS = "/race/runner-clubs";
    static final String SEARCH = "/search";

    private RunnerClubService runnerClubService;

    @Autowired
    public RunnerClubResource(RunnerClubService runnerClubService) {
        this.runnerClubService = runnerClubService;
    }

    @PostMapping
    public RunnerClub create(@RequestBody RunnerClubCreation runnerClubCreation) {
        return this.runnerClubService.create(runnerClubCreation);
    }

    @GetMapping(SEARCH)
    public Stream<String> findRunnerClubDistinctNamesWithProfessionalRunnersByRaceName(@RequestParam String q) {
        String raceName = new LexicalAnalyzer().extractWithAssure(q, "race-name");
        return this.runnerClubService.findRunnerClubNameWithProfessionalRunnersByRaceName(raceName);
    }
}
