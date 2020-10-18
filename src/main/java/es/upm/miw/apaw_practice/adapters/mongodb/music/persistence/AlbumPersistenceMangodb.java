package es.upm.miw.apaw_practice.adapters.mongodb.music.persistence;


import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.AlbumRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.AlbumPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("albumPersistence")
public class AlbumPersistenceMangodb implements AlbumPersistence {
    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumPersistenceMangodb(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    @Override
    public void deleteById(String id){
        this.albumRepository.deleteById(id);
    }
}
