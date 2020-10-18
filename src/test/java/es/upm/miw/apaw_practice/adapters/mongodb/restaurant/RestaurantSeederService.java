package es.upm.miw.apaw_practice.adapters.mongodb.restaurant;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.FoodTypeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.OwnerRestaurantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.PhysicalStoreRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.RestaurantRepository;
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
    @Autowired
    private RestaurantRepository restaurantRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Restaurant Initial Load -----------");

        PhysicalStoreEntity[] physicalStore = {
                new PhysicalStoreEntity("tag1", "address1", 500, true, LocalDateTime.of(2019, 12, 3, 10, 00)),
                new PhysicalStoreEntity("tag2", "address2", 600, false, LocalDateTime.of(2016, 01, 14, 14, 30)),
                new PhysicalStoreEntity("tag3", "address3", 700, false, LocalDateTime.of(2017, 07, 24, 14, 30)),
                new PhysicalStoreEntity("tag4", "address4", 550, false, LocalDateTime.of(2015, 10, 17, 10, 30)),
                new PhysicalStoreEntity("tag5", "address5", 810, true, LocalDateTime.of(2013, 05, 24, 11, 30))
        };
        this.physicalStoreRepository.saveAll(Arrays.asList(physicalStore));
        FoodTypeEntity[] foodType = {
                new FoodTypeEntity("foodType1", "type1", false),
                new FoodTypeEntity("foodType2", "type2", true),
                new FoodTypeEntity("foodType3", "type3", true),
                new FoodTypeEntity("foodType4", "type4", false),
                new FoodTypeEntity("foodType5", "type5", false)
        };
        this.foodTypeRepository.saveAll(Arrays.asList(foodType));
        OwnerRestaurantEntity[] owner = {
                new OwnerRestaurantEntity("tag1", "Lara", "Martinez"),
                new OwnerRestaurantEntity("tag2", "Pepa", "Felix"),
                new OwnerRestaurantEntity("tag3", "Miriam", "Pez")
        };
        this.ownerRepository.saveAll(Arrays.asList(owner));
        RestaurantEntity[] restaurant = {
                new RestaurantEntity("tag1", "name1", 9.0, List.of(physicalStore[0], physicalStore[1]),
                        List.of(foodType[0], foodType[1]), owner[0]),
                new RestaurantEntity("tag2", "name2", 7.0, List.of(physicalStore[2]),
                        List.of(foodType[3], foodType[1]), owner[1]),
                new RestaurantEntity("tag3", "name3", 6.0, List.of(physicalStore[3]),
                        List.of(foodType[1], foodType[4]), owner[0]),
                new RestaurantEntity("tag4", "name4", 9.5, List.of(physicalStore[4]),
                        List.of(foodType[0], foodType[2]), owner[2])
        };
        this.restaurantRepository.saveAll((Arrays.asList(restaurant)));
    }

    public void deleteAll() {
        this.physicalStoreRepository.deleteAll();
        this.foodTypeRepository.deleteAll();
        this.ownerRepository.deleteAll();
    }
}
