package es.upm.miw.apaw_practice.adapters.rest.FurnitureFactory;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.WarehouseAreaUpdating;
import es.upm.miw.apaw_practice.domain.services.FurnitureFactory.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(WarehouseResource.WAREHOUSES)
public class WarehouseResource {
    static final String WAREHOUSES = "/FurnitureFactory/warehouses";

    private WarehouseService warehouseService;

    @Autowired
    public WarehouseResource(WarehouseService warehoueService) {
        this.warehouseService = warehoueService;
    }

    @PatchMapping
    public void updateArea(@RequestBody List<WarehouseAreaUpdating> warehouseAreaUpdatingList) {
        this.warehouseService.updateArea(warehouseAreaUpdatingList);
    }


}

