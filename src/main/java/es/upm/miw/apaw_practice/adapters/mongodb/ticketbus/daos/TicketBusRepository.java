package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.TicketBusEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketBusRepository extends MongoRepository<TicketBusEntity, String> {
}
