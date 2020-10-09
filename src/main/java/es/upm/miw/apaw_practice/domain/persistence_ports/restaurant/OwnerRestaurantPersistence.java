package es.upm.miw.apaw_practice.domain.persistence_ports.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.OwnerRestaurant;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface OwnerRestaurantPersistence {
    Stream<OwnerRestaurant> readName();
}
