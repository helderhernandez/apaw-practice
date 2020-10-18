package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.restaurant.FoodTypeDto;
import es.upm.miw.apaw_practice.domain.models.restaurant.FoodType;
import es.upm.miw.apaw_practice.domain.models.restaurant.FoodTypeSpicyUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.FoodTypePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class FoodTypeService {
    private FoodTypePersistence foodTypePersistence;

    @Autowired
    public FoodTypeService(FoodTypePersistence foodTypePersistence) {
        this.foodTypePersistence = foodTypePersistence;
    }

    public void updateSpicy(FoodTypeSpicyUpdating spicyUpdating) {
        FoodType foodType = this.foodTypePersistence.findById(spicyUpdating.getId());
        foodType.setSpicy(spicyUpdating.getSpicy());
        this.foodTypePersistence.update(foodType);
    }

    public Stream<FoodType> findFoodTypesAssociateToOwner(String owner) {
        return this.foodTypePersistence.findFoodTypesAssociateToOwner(owner);
    }
}
