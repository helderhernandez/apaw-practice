package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.OwnerRestaurant;
import es.upm.miw.apaw_practice.domain.models.restaurant.OwnerRestaurantUpdate;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.OwnerRestaurantPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class OwnerRestaurantService {

    private final OwnerRestaurantPersistence ownerRestaurantPersistence;

    @Autowired
    public OwnerRestaurantService(OwnerRestaurantPersistence ownerRestaurantPersistence) {
        this.ownerRestaurantPersistence = ownerRestaurantPersistence;
    }

    public Stream<OwnerRestaurant> readName() {
        return this.ownerRestaurantPersistence.readName();
    }

    public OwnerRestaurant updateOwner(String id, OwnerRestaurantUpdate ownerRestaurantUpdate) {
        return this.ownerRestaurantPersistence.updateOwner(id, ownerRestaurantUpdate);
    }
}
