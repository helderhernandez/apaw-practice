package es.upm.miw.apaw_practice.adapters.mongodb.music.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.SingerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SingerRepository extends MongoRepository<SingerEntity,String> {
}
