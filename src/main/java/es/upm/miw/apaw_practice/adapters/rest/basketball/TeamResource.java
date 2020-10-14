package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.domain.services.basketball.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TeamResource.TEAMS)
public class TeamResource {
    static final String TEAMS = "/basketball/teams";

    static final String ID_ID = "/{id}";

    private TeamService teamService;

    @Autowired
    public TeamResource(TeamService teamService) {
        this.teamService = teamService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.teamService.delete(id);
    }
}
