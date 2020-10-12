package es.upm.miw.apaw_practice.domain.persistence_ports.music;

import es.upm.miw.apaw_practice.domain.models.music.Singer;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface SingerPersistence {
    Stream<Singer> readAll();
}
