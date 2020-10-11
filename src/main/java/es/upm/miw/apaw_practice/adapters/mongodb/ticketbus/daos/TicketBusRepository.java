package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.TicketBusEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TicketBusRepository extends MongoRepository<TicketBusEntity, String> {
    Optional<TicketBusEntity> findByReference(String reference);

    void deleteByReference(String reference);
}
