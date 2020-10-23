
package es.upm.miw.apaw_practice.adapters.rest.music;


import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.music.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(AlbumResource.ALBUMS)
public class AlbumResource {
    static final String ALBUMS = "/music/albums";
    static final String ID_ID = "/{id}";
    static final String SEARCH = "/search";

    private final AlbumService albumService;

    @Autowired
    public AlbumResource(AlbumService albumService){
        this.albumService = albumService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id){
        this.albumService.delete(id);
    }

    @GetMapping(SEARCH)
    public BigDecimal findTotalPriceAlbumByStyleName(@RequestParam String q){
        String name = new LexicalAnalyzer().extractWithAssure(q,"name");
        return this.albumService.findTotalPriceAlbumByStyleName(name);
    }
}
