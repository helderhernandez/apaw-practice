package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import es.upm.miw.apaw_practice.domain.models.museum.ArtistCountryUpdating;
import es.upm.miw.apaw_practice.domain.services.museum.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(ArtistResource.ARTISTS)
public class ArtistResource {

    static final String ARTISTS = "/museum/artists";

    private ArtistService artistService;

    @Autowired
    public ArtistResource(ArtistService artistService) { this.artistService = artistService; }

    @GetMapping
    public Stream<Artist> readAll()
    {
        return this.artistService.readAll();
    }

    @PatchMapping
    public void updateCountry(@RequestBody ArtistCountryUpdating artistCountryUpdating){
        this.artistService.updateCounrty(artistCountryUpdating);
    }

}
