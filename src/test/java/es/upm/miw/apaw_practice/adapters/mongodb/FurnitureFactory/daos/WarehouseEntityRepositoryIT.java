package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.AddressEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.WarehouseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class WarehouseEntityRepositoryIT {
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Test
    void testFindByName() {
        assertTrue(this.warehouseRepository.findByName("a").isPresent());
        WarehouseEntity warehouse = this.warehouseRepository.findByName("a").get();
        assertEquals("1200m³", warehouse.getArea());
    }
    @Test
    void testCreateAndRead() {
        assertTrue(this.warehouseRepository.findAll().stream()
                .anyMatch(warehouse ->
                        "b".equals(warehouse.getName()) &&
                                "1300m³".equals(warehouse.getArea())&&
                                Boolean.TRUE.equals(warehouse.getActive())&&
                                warehouse.getId()!=null&&
                                "China".equals(warehouse.getAddressEntity().get(0).getCountry()) &&
                                "Jose".equals(warehouse.getEmployeeEntity().get(0).getFirstName())&&
                                "Desk".equals(warehouse.getFurnitureEntity().get(0).getName())
                ));
    }
}
