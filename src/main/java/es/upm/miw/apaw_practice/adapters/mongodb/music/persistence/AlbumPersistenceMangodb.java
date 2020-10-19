package es.upm.miw.apaw_practice.adapters.mongodb.music.persistence;


import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.AlbumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.MusicRepository;
import es.upm.miw.apaw_practice.domain.models.music.Album;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.AlbumPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Repository("albumPersistence")
public class AlbumPersistenceMangodb implements AlbumPersistence {
    private final AlbumRepository albumRepository;
    private final MusicRepository musicRepository;

    @Autowired
    public AlbumPersistenceMangodb(AlbumRepository albumRepository,MusicRepository musicRepository){
        this.albumRepository = albumRepository;
        this.musicRepository = musicRepository;
    }

    @Override
    public void deleteById(String id){
        this.albumRepository.deleteById(id);
    }

    @Override
    public BigDecimal findTotalPriceAlbumByStyleName(String name){
        BigDecimal total = findPriceAlbumByStyleName(name)
                .map(Album::getPrice)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0.00"));
        return total;
    }
    public Stream<Album> findPriceAlbumByStyleName(String name){
        return this.albumRepository.findAll()
                .stream()
                .map(albumEntity -> albumEntity.toAlbum())
                .filter(album -> album.getMusicEntityList().stream()
                        .map(musicEntity -> musicEntity.getStyleEntity()
                                .getName()).anyMatch(nameAlbum -> nameAlbum.equals(name)));
    }
}
