package es.upm.miw.apaw_practice.adapters.mongodb.padel.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.RacketEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RacketRepository extends MongoRepository<RacketEntity,String> {
    List<RacketEntity> findAllByBrand(String brand);


}
