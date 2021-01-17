package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.museum.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(PatronResource.PATRONS)
public class PatronResource {

    static final String PATRONS = "/muesum/patrons";
    static final String SEARCH = "/search";

    private PatronService patronService;

    @Autowired
    PatronResource(PatronService patronService) { this.patronService = patronService;}

    @GetMapping(SEARCH)
    public Stream<String>findPatronsIDByArtistName(@RequestParam String q) {
        String artistName = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.patronService.findPatronsIDByArtistName(artistName);
    }
}
