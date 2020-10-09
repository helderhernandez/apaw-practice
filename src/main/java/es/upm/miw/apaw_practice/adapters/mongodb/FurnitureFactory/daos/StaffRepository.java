package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos;


import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.StaffEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface StaffRepository extends MongoRepository<StaffEntity, String> {
    Optional<StaffEntity> findByDni(String dni);
}
