package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos.FurnitureRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos.WarehouseRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.FurnitureEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Furniture;
import es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory.FurniturePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Repository("furniturePersistence")
public class FurniturePersistenceMongodb implements FurniturePersistence {
    private final FurnitureRepository furnitureRepository;
    private final WarehouseRepository warehouseRepository;

    @Autowired
    public FurniturePersistenceMongodb(FurnitureRepository furnitureRepository, WarehouseRepository warehouseRepository) {
        this.furnitureRepository = furnitureRepository;
        this.warehouseRepository = warehouseRepository;
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

    @Override
    public Furniture findTotalPriceFurnitureByStreet(String street) {
        BigDecimal total = findPriceFurnitureByStreet(street)
                .map(Furniture::getPrice)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0.00"));
        Furniture totalFurniture = new Furniture();
        totalFurniture.setPrice(total);
        return totalFurniture;
    }

    public Stream<Furniture> findPriceFurnitureByStreet(String street) {
        return warehouseRepository.findAll()
                .stream()
                .map(warehouseEntity -> warehouseEntity.toWarehouse())
                .filter(warehouseEntity -> warehouseEntity.getAddressEntity().stream()
                        .anyMatch(addressEntity -> addressEntity.getStreet().equals(street)))
                .flatMap(warehouse -> warehouse.getFurnitureEntity().stream())
                .map(furnitureEntity -> furnitureEntity.toFurniture());

    }

}
