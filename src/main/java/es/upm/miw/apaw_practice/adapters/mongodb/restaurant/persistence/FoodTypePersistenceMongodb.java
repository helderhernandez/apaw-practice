package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.FoodTypeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.FoodTypeEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.restaurant.FoodType;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.FoodTypePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("foodTypePersistence")
public class FoodTypePersistenceMongodb implements FoodTypePersistence {
    private FoodTypeRepository foodTypeRepository;

    @Autowired
    public FoodTypePersistenceMongodb(FoodTypeRepository foodTypeRepository) {
        this.foodTypeRepository = foodTypeRepository;
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
}
