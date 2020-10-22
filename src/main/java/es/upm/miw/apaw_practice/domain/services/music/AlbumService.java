

package es.upm.miw.apaw_practice.domain.services.music;

import es.upm.miw.apaw_practice.domain.models.music.Album;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.AlbumPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AlbumService {
    private final AlbumPersistence albumPersistence;

    @Autowired
    public AlbumService(AlbumPersistence albumPersistence){
        this.albumPersistence = albumPersistence;
    }
    public void delete(String id){
        this.albumPersistence.deleteById(id);
    }
    public BigDecimal findTotalPriceAlbumByStyleName(String name){
        return this.albumPersistence.findTotalPriceAlbumByStyleName(name);
    }
}