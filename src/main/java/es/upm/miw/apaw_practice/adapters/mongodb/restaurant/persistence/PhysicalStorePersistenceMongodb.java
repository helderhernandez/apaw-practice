package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.PhysicalStoreRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.PhysicalStoreEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.restaurant.PhysicalStore;
import es.upm.miw.apaw_practice.domain.models.restaurant.Restaurant;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.PhysicalStorePersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.RestaurantPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("physicalStorePersistence")
public class PhysicalStorePersistenceMongodb implements PhysicalStorePersistence {

    private PhysicalStoreRepository physicalStoreRepository;

    private RestaurantPersistence restaurantPersistence;

    @Autowired
    public PhysicalStorePersistenceMongodb(PhysicalStoreRepository physicalStoreRepository, RestaurantPersistence restaurantPersistence) {
        this.physicalStoreRepository = physicalStoreRepository;
        this.restaurantPersistence = restaurantPersistence;
    }

    private void assertAddressNotExist(String address) {
        this.physicalStoreRepository.findByAddress(address)
                .ifPresent(dbAddress -> {
                    throw new ConflictException("This address" + address + "exist yet");
                });
    }

    @Override
    public PhysicalStore create(PhysicalStore physicalStore) {
        this.assertAddressNotExist(physicalStore.getAddress());
        return this.physicalStoreRepository.save(new PhysicalStoreEntity(physicalStore))
                .toPhysicalStore();
    }

    @Override
    public void deletePhysicalStore(String address) {
        PhysicalStoreEntity physicalStoreEntity = this.physicalStoreRepository.findByAddress(address)
                .orElseThrow(() -> new NotFoundException("Not find address: " + address));
        this.physicalStoreRepository.delete(physicalStoreEntity);
    }

    @Override
    public Stream<PhysicalStore> findAddressPhysicalStoreWithAFoodTypeScoreHigherThan(String idFoodType, Double score) {
        Stream<Restaurant> allRestaurants = this.restaurantPersistence.readAll();
        Stream<Restaurant> restaurantsScore = this.restaurantScoreHigherThan(allRestaurants, score);
        Stream<Restaurant> restaurants = this.restaurantSameFoodType(restaurantsScore, idFoodType);
        return restaurants
                .flatMap(store -> store.getPhysicalStoreEntities().stream());
    }

    public Stream<Restaurant> restaurantScoreHigherThan(Stream<Restaurant> restaurants, Double score) {
        return restaurants.filter(restaurantScore ->
                restaurantScore.getScore() > score);
    }

    public Stream<Restaurant> restaurantSameFoodType(Stream<Restaurant> restaurantsScore, String idFoodtype) {
        return restaurantsScore.filter(restaurant ->
                restaurant.getFoodTypeEntities().stream()
                        .anyMatch(foodType -> foodType.getId().equals(idFoodtype)));
    }
}
