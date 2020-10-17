package es.upm.miw.apaw_practice.adapters.rest.race;

import es.upm.miw.apaw_practice.domain.models.race.Runner;
import es.upm.miw.apaw_practice.domain.models.race.RunnerProfessionalUpdating;
import es.upm.miw.apaw_practice.domain.services.race.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RunnerResource.RUNNERS)
public class RunnerResource {

    static final String RUNNERS = "/race/runners";
    static final String ID_ID = "/{id}";

    private RunnerService runnerService;

    @Autowired
    public RunnerResource(RunnerService runnerService) {
        this.runnerService = runnerService;
    }

    @GetMapping(ID_ID)
    public Runner read(@PathVariable String id) {
        return runnerService.readById(id);
    }

    @PatchMapping
    public void updateProfessional(@RequestBody List<RunnerProfessionalUpdating> runnerProfessionalUpdatingList) {
        this.runnerService.updateProfessional(runnerProfessionalUpdatingList);
    }

}
