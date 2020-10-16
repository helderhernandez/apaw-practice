package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.FoodType;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.RestaurantPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class RestaurantService {
    private RestaurantPersistence restaurantPersistence;

    @Autowired
    public RestaurantService(RestaurantPersistence restaurantPersistence) {
        this.restaurantPersistence = restaurantPersistence;
    }

    public Stream<String> findFoodTypesAssociateToOwner(String owner) {
        return this.restaurantPersistence.readAll()
                .filter(restaurant ->
                        restaurant.getOwnerEntities().getName().equals(owner))
                .flatMap(foodType -> foodType.getFoodTypeEntities().stream()
                .map(id -> id.getId()))
                .distinct();
    }
}
