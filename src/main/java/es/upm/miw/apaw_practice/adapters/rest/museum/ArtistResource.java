package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import es.upm.miw.apaw_practice.domain.services.museum.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
