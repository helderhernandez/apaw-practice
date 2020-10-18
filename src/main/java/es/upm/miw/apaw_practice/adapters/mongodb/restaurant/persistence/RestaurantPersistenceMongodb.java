package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.RestaurantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.RestaurantEntity;
import es.upm.miw.apaw_practice.domain.models.restaurant.Restaurant;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.RestaurantPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("restaurantPersistence")
public class RestaurantPersistenceMongodb implements RestaurantPersistence {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantPersistenceMongodb(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Stream<Restaurant> readAll() {
        return this.restaurantRepository.findAll().stream()
                .map(RestaurantEntity::toRestaurant);
    }
}
