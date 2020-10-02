package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SpecialityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpecialityRepository extends MongoRepository<SpecialityEntity, String> {

}
