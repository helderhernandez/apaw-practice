package es.upm.miw.apaw_practice.domain.services.FurnitureFactory;

import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Warehouse;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.WarehouseAreaUpdating;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import es.upm.miw.apaw_practice.domain.models.shop.ArticleCreation;
import es.upm.miw.apaw_practice.domain.models.shop.ArticlePriceUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.FurnitureFactory.WarehousePersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.shop.ArticlePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@Service
public class WarehouseService {

    private WarehousePersistence warehousePersistence;

    @Autowired
    public WarehouseService(WarehousePersistence warehousePersistence) {
        this.warehousePersistence = warehousePersistence;
    }


    public void updateArea(List<WarehouseAreaUpdating> warehouseAreaUpdatingList) {
        warehouseAreaUpdatingList.stream()
                .map(warehouseNewArea -> {
                    Warehouse warehouse = this.warehousePersistence.readByName(warehouseNewArea.getName());
                    warehouse.setArea(warehouseNewArea.getArea());
                    return warehouse;
                })
                .forEach(this.warehousePersistence::update);
    }


}
