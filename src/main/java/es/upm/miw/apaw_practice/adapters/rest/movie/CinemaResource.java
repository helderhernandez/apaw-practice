package es.upm.miw.apaw_practice.adapters.rest.movie;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.movie.Cinema;
import es.upm.miw.apaw_practice.domain.models.movie.CinemaMovieTicketPriceUpdating;
import es.upm.miw.apaw_practice.domain.services.movie.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(CinemaResource.CINEMAS)
public class CinemaResource {
    static final String CINEMAS = "/movie/cinemas";

    static final String SEARCH = "/search";

    private CinemaService cinemaService;

    @Autowired
    public CinemaResource(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @PatchMapping
    public void updateMovieTicketPrice(@RequestBody List<CinemaMovieTicketPriceUpdating> cinemaMovieTicketPriceUpdatingList) {
        this.cinemaService.updateMovieTicketPrice(cinemaMovieTicketPriceUpdatingList);
    }

    @GetMapping(SEARCH)
    public Stream<Cinema> findByNameAndFulNameDirector(@RequestParam String q) {
        String name = new LexicalAnalyzer().extractWithAssure(q, "name");
        String fulName = new LexicalAnalyzer().extractWithAssure(q, "fulName");
        return this.cinemaService.findByNameAndFulNameDirector(name, fulName);
    }
}
