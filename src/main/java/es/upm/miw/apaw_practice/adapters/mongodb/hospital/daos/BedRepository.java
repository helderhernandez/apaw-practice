package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.BedEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BedRepository extends MongoRepository<BedEntity, String> {
    Optional<List<BedEntity>> findByInternedDate(LocalDateTime internedDate);
}
