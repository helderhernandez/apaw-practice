package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos;


import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.FurnitureEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FurnitureRepository extends MongoRepository<FurnitureEntity, String> {
}