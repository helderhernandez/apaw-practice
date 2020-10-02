package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.shop.entities.ArticleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<ArticleEntity, String> {

}
