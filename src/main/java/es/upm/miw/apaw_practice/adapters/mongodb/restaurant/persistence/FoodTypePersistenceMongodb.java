package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.FoodTypeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.FoodTypeEntity;
import es.upm.miw.apaw_practice.adapters.rest.restaurant.FoodTypeDto;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.restaurant.FoodType;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.FoodTypePersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.RestaurantPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("foodTypePersistence")
public class FoodTypePersistenceMongodb implements FoodTypePersistence {
    private FoodTypeRepository foodTypeRepository;
    private RestaurantPersistence restaurantPersistence;

    @Autowired
    public FoodTypePersistenceMongodb(FoodTypeRepository foodTypeRepository, RestaurantPersistence restaurantPersistence) {
        this.foodTypeRepository = foodTypeRepository;
        this.restaurantPersistence = restaurantPersistence;
    }

    @Override
    public FoodType findById(String id) {
        return this.foodTypeRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Food type id: " + id))
                .toFoodType();
    }

    @Override
    public FoodType update(FoodType spicyUpdating) {
        FoodTypeEntity foodTypeEntity =
                this.foodTypeRepository.findById(spicyUpdating.getId())
                        .orElseThrow(() -> new NotFoundException("Not find the type of food whit this id: " + spicyUpdating.getId()));
        foodTypeEntity.formFoodType(spicyUpdating);
        return this.foodTypeRepository.save(foodTypeEntity).toFoodType();
    }

    @Override
    public Stream<FoodType> findFoodTypesAssociateToOwner(String owner) {
        return this.restaurantPersistence.readAll()
                .filter(restaurant ->
                        restaurant.getOwnerEntities().getName().equals(owner))
                .flatMap(foodType -> foodType.getFoodTypeEntities().stream());
    }
}
