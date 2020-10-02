package es.upm.miw.apaw_practice.adapters.mongodb.factory.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.MachineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface MachineRepository extends MongoRepository<MachineEntity, String> {
    Optional<MachineEntity> findBySerialNumber(Long serialNumber);
}