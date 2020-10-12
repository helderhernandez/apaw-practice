package es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory;

import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Warehouse;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousePersistence {
    Warehouse update(Warehouse warehouse);
    Warehouse readByName(String name);
}
