package es.upm.miw.apaw_practice.adapters.rest.movie;

import es.upm.miw.apaw_practice.domain.models.movie.CinemaMovieTicketPriceUpdating;
import es.upm.miw.apaw_practice.domain.services.movie.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CinemaResource.CINEMAS)
public class CinemaResource {
    static final String CINEMAS = "/movie/cinemas";

    private CinemaService cinemaService;

    @Autowired
    public CinemaResource(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @PatchMapping
    public void updateMovieTicketPrice(@RequestBody List<CinemaMovieTicketPriceUpdating> cinemaMovieTicketPriceUpdatingList) {
        this.cinemaService.updateMovieTicketPrice(cinemaMovieTicketPriceUpdatingList);
    }
}
