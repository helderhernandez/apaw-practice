
package es.upm.miw.apaw_practice.adapters.rest.music;


import es.upm.miw.apaw_practice.domain.services.music.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
