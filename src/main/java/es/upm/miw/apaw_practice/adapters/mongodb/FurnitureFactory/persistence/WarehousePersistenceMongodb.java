package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos.WarehouseRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.WarehouseEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Warehouse;
import es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory.WarehousePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("warehousePersistence")
public class WarehousePersistenceMongodb implements WarehousePersistence {

    private WarehouseRepository warehouseRepository;

    @Autowired
    public WarehousePersistenceMongodb(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public Warehouse readByName(String name) {
        return this.warehouseRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Warehouse name: " + name))
                .toWarehouse();
    }
    @Override
    public Warehouse update(Warehouse warehouse) {
        WarehouseEntity warehouseEntity = this.warehouseRepository
                .findById(warehouse.getId())
                .orElseThrow(() -> new NotFoundException("Warehouse id: " + warehouse.getId()));
        warehouseEntity.fromWarehouse(warehouse);
        return this.warehouseRepository
                .save(warehouseEntity)
                .toWarehouse();
    }

}
