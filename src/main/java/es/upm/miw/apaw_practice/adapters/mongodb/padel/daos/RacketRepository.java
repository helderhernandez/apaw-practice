package es.upm.miw.apaw_practice.adapters.mongodb.padel.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.RacketEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RacketRepository extends MongoRepository<RacketEntity,String> {
    Optional<List<RacketEntity>> findAllByBrand(String brand);
}
