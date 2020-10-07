package es.upm.miw.apaw_practice.adapters.rest.sportcentre;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.sportcentre.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(SessionResource.SESSIONS)
public class SessionResource {

    static final String SESSIONS = "/sportcentre/sessions";
    static final String SEARCH_INSTRUCTOR = "/search-instructor";
    static final String SEARCH_SPECIALITY = "/search-speciality";
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

    @GetMapping(SEARCH_INSTRUCTOR)
    public Stream<String> findNameAssistantsSessionByInstructor(@RequestParam String q){
        String nameInstructor = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.sessionService.findNameAssistantsSessionByInstructor(nameInstructor);
    }

    @GetMapping(SEARCH_SPECIALITY)
    public BasicSessionDto findSessionBySpecialityTitle(@RequestParam String q){
        String title = new LexicalAnalyzer().extractWithAssure(q, "title");
        return this.sessionService.findSessionBySpecialityTitle(title)
                .toBasicSessionDto();
    }

}
