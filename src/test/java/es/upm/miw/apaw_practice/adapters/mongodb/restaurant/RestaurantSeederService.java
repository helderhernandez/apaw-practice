package es.upm.miw.apaw_practice.adapters.mongodb.restaurant;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.FoodTypeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.OwnerRestaurantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.PhysicalStoreRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.FoodTypeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.OwnerRestaurantEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.PhysicalStoreEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.RestaurantEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class RestaurantSeederService {
    @Autowired
    private PhysicalStoreRepository physicalStoreRepository;
    @Autowired
    private FoodTypeRepository foodTypeRepository;
    @Autowired
    private OwnerRestaurantRepository ownerRepository;

    public void seedDatabase(){
        LogManager.getLogger(this.getClass()).warn("------- Restaurant Initial Load -----------");

        PhysicalStoreEntity[] physicalStore = {
                new PhysicalStoreEntity("tag1", "address1", 500, true, LocalDateTime.of(2019, 12, 3,10,00)),
                new PhysicalStoreEntity("tag2", "address2", 600, false, LocalDateTime.of(2016,03,14,14,30))
        };
        this.physicalStoreRepository.saveAll(Arrays.asList(physicalStore));
        FoodTypeEntity[] foodType = {
                new FoodTypeEntity("tag1", "type1", false),
                new FoodTypeEntity("tag2", "type2", true),
                new FoodTypeEntity("tag3", "type3", true)
        };
        this.foodTypeRepository.saveAll(Arrays.asList(foodType));
        OwnerRestaurantEntity[] owner = {
                new OwnerRestaurantEntity("tag1", "name1","familyName1"),
                new OwnerRestaurantEntity("tag2", "name2","familyName2"),
                new OwnerRestaurantEntity("tag3", "name3","familyName3")
        };
        this.ownerRepository.saveAll(Arrays.asList(owner));
        RestaurantEntity[] restaurant = {
          new RestaurantEntity("tag1", "name1", 9.0, List.of(physicalStore[0],physicalStore[1]),
                  List.of(foodType[0],foodType[1]), owner[0])
        };
    }

    public void deleteAll() {
        this.physicalStoreRepository.deleteAll();
        this.foodTypeRepository.deleteAll();
        this.ownerRepository.deleteAll();
    }
}
