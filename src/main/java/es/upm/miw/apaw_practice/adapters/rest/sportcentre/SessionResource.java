package es.upm.miw.apaw_practice.adapters.rest.sportcentre;

import es.upm.miw.apaw_practice.domain.services.sportcentre.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SessionResource.SESSIONS)
public class SessionResource {

    static final String SESSIONS = "/sportcentre/sessions";
    static final String ID_ID = "/{id}";

    private SessionService sessionService;

    @Autowired
    public SessionResource(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id){
        this.sessionService.delete(id);
    }

}
