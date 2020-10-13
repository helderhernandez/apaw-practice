package es.upm.miw.apaw_practice.adapters.mongodb.property.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.MaintanenceItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MaintanenceItemRepository extends MongoRepository<MaintanenceItemEntity,String> {
    Optional<MaintanenceItemEntity> findByInvoice(Long invoice);
    Optional<MaintanenceItemEntity> findById(String id);
}
