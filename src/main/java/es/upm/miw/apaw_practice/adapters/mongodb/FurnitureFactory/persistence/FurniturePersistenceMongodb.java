package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos.FurnitureRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.FurnitureEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Furniture;
import es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory.FurniturePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("furniturePersistence")
public class FurniturePersistenceMongodb implements FurniturePersistence {
    private final FurnitureRepository furnitureRepository;

    @Autowired
    public FurniturePersistenceMongodb(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    @Override
    public Stream<Furniture> readAll() {
        return this.furnitureRepository.findAll().stream()
                .map(furnitureEntity -> furnitureEntity.toFurniture());
    }
    @Override
    public Furniture updateName(String id, String name) {
        FurnitureEntity furnitureEntity = this.furnitureRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Furniture id: " + id));
        furnitureEntity.setName(name);
        return this.furnitureRepository.save(furnitureEntity).toFurniture();
    }



}
