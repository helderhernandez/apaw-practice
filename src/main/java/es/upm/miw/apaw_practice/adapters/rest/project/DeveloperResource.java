package es.upm.miw.apaw_practice.adapters.rest.project;

import es.upm.miw.apaw_practice.domain.models.project.Developer;
import es.upm.miw.apaw_practice.domain.services.project.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DeveloperResource.DEVELOPER)
public class DeveloperResource {

    static final String DEVELOPER = "/project/issues";
    static final String ID_ID = "/{id}";
    static final String YEARS_OF_EXPERIENCE = "/years-of-experience";

    private DeveloperService developerService;

    @Autowired
    public DeveloperResource(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PutMapping(ID_ID + YEARS_OF_EXPERIENCE)
    public Developer updateYearsOfExperience(@PathVariable String id, @RequestBody int yearsOfExperience) {
        return this.developerService.updateYearsOfExperience(id, yearsOfExperience);
    }

}
