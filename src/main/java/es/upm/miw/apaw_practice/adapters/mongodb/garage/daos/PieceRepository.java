package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.PieceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PieceRepository extends MongoRepository<PieceEntity, String> {

}
