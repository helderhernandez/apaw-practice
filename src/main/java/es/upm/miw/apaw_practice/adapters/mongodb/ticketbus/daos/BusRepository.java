package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.BusEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BusRepository extends MongoRepository<BusEntity, String> {

    Optional<BusEntity> findByReference(String reference);

}
