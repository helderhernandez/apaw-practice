package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.BusEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusRepository extends MongoRepository<BusEntity, String> {
}
