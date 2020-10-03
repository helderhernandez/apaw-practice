package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<ClientEntity, String> {
}
