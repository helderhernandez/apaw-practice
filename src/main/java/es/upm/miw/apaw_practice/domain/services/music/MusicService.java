package es.upm.miw.apaw_practice.domain.services.music;

import es.upm.miw.apaw_practice.domain.models.music.Music;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.MusicPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class MusicService {
    private final MusicPersistence musicPersistence;

    @Autowired
    public MusicService(MusicPersistence musicPersistence){
        this.musicPersistence = musicPersistence;
    }

    public Music updateName(String id, String name){
        return this.musicPersistence.updateName(id, name);
    }

    public Stream<Music>findMusicBySingerName(String name){
        return this.musicPersistence.findMusicBySingerName(name);
    }

}
