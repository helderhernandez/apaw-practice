package es.upm.miw.apaw_practice.domain.persistence_ports.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.FoodType;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodTypePersistence {
    FoodType update(FoodType spicyUpdating);

    FoodType readById(String id);
}
