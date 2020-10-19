package es.upm.miw.apaw_practice.adapters.mongodb.music.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.AlbumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.MusicRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.MusicEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.music.Music;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.MusicPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;


@Repository("musicPersistence")
public class MusicPersistenceMangodb implements MusicPersistence {

    private final MusicRepository musicRepository;
    private final AlbumRepository albumRepository;

    @Autowired
    public MusicPersistenceMangodb(MusicRepository musicRepository,AlbumRepository albumRepository){
        this.musicRepository = musicRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public Music updateName(String id,String name){
        MusicEntity musicEntity = this.musicRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Music id:" + id));
        musicEntity.setName(name);
        return this.musicRepository.save(musicEntity).toMusic();
    }

    @Override
    public Stream<Music> findMusicBySingerName(String name) {
        return this.albumRepository.findAll().stream()
                .map(albumEntity -> albumEntity.toAlbum())
                .filter(album -> album.getSingerEntityList().stream()
                        .anyMatch(singerEntity -> singerEntity.getName().equals(name)))
                .map(album -> album.getMusicEntityList())
                .flatMap(musicEntities -> musicEntities.stream())
                .map(musicEntity -> musicEntity.toMusic());
    }
}