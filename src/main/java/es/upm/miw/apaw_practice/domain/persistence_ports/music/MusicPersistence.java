package es.upm.miw.apaw_practice.domain.persistence_ports.music;

import es.upm.miw.apaw_practice.domain.models.music.Music;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface MusicPersistence {
    Music updateName(String id,String name);
    Stream<Music> findMusicBySingerName(String name);
}
