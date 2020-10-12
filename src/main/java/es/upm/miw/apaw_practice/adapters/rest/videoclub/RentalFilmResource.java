package es.upm.miw.apaw_practice.adapters.rest.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.RentalFilm;
import es.upm.miw.apaw_practice.domain.services.videoclub.RentalFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RentalFilmResource.FILMS)
public class RentalFilmResource {
    static final String FILMS = "/videoclub/films";
    static final String REF_REF = "/{reference}";

    private RentalFilmService rentalFilmService;

    @Autowired
    public RentalFilmResource(RentalFilmService rentalFilmService) {
        this.rentalFilmService = rentalFilmService;
    }

    @GetMapping(REF_REF)
    public RentalFilm read(@PathVariable String reference) {
        return this.rentalFilmService.read(reference);
    }

}
