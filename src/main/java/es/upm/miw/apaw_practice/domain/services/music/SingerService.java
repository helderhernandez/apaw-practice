package es.upm.miw.apaw_practice.domain.services.music;

import es.upm.miw.apaw_practice.domain.models.music.Singer;
import es.upm.miw.apaw_practice.domain.persistence_ports.music.SingerPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.StudentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class SingerService {

    private final SingerPersistence singerPersistence;

    @Autowired
    public SingerService(SingerPersistence singerPersistence){
        this.singerPersistence = singerPersistence;
    }

    public Stream<Singer> readAll(){
        return this.singerPersistence.readAll();
    }

}
