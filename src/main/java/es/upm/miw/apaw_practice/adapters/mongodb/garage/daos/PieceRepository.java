package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.PieceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PieceRepository extends MongoRepository<PieceEntity, String> {
    Optional<PieceEntity> findByBarcode(String barcode);

    Optional<PieceEntity> findByNameAndManufacturer(String name, String manufacturer);
}
