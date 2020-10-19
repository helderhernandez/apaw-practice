package es.upm.miw.apaw_practice.domain.persistence_ports.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.restaurant.FoodTypeDto;
import es.upm.miw.apaw_practice.domain.models.restaurant.FoodType;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface FoodTypePersistence {
    FoodType update(FoodType spicyUpdating);

    FoodType findById(String id);

    Stream<FoodType> findFoodTypesAssociateToOwner(String owner);
}
