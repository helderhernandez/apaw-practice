package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.CustomerAssociateEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerAssociateRepository extends MongoRepository<CustomerAssociateEntity, String> {
    Optional<CustomerAssociateEntity> findByDocumentId(String documentId);

    void deleteByDocumentId(String documentId);
}
