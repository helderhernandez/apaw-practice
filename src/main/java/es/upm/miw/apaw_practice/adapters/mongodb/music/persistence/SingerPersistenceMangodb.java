package es.upm.miw.apaw_practice.adapters.mongodb.music.persistence;


import es.upm.miw.apaw_practice.adapters.mongodb.music.daos.SingerRepository;
import es.upm.miw.apaw_practice.domain.models.music.Singer;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.SingerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("singerPersistence")
public class SingerPersistenceMangodb implements SingerPersistence {
    private final SingerRepository singerRepository;

    @Autowired
    public SingerPersistenceMangodb(SingerRepository singerRepository){
        this.singerRepository = singerRepository;
    }

    @Override
    public Stream<Singer> readAll(){
        return this.singerRepository.findAll().stream()
                .map(singerEntity -> singerEntity.toSinger());
    }

}
