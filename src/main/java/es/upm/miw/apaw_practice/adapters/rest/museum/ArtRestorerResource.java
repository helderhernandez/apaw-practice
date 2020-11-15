package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.domain.models.museum.ArtRestorer;
import es.upm.miw.apaw_practice.domain.services.museum.ArtRestorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ArtRestorerResource.ART_RESTORERS)
public class ArtRestorerResource {

    static final String ART_RESTORERS = "/museum/art-restorers";
    static final String ID_ID = "/{id}";

    private ArtRestorerService artRestorerService;

    @Autowired
    public ArtRestorerResource(ArtRestorerService artRestorerService) {
        this.artRestorerService = artRestorerService;
    }

    @PutMapping(ID_ID)
    public ArtRestorer update(@PathVariable String id, @RequestBody ArtRestorer artRestorer){
        return this.artRestorerService.update(id, artRestorer);
    }
}
