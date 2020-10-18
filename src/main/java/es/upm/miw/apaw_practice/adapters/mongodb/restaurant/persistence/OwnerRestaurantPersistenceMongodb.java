package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.OwnerRestaurantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.OwnerRestaurantEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.restaurant.OwnerRestaurant;
import es.upm.miw.apaw_practice.domain.models.restaurant.OwnerRestaurantUpdate;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.OwnerRestaurantPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("ownerRestaurantPersistence")
public class OwnerRestaurantPersistenceMongodb implements OwnerRestaurantPersistence {

    private OwnerRestaurantRepository ownerRestaurantRepository;

    @Autowired
    public OwnerRestaurantPersistenceMongodb(OwnerRestaurantRepository ownerRestaurantRepository){
        this.ownerRestaurantRepository = ownerRestaurantRepository;
    }

    @Override
    public Stream<OwnerRestaurant> readName() {
        return this.ownerRestaurantRepository.findAll().stream()
                .map(ownerRestaurantEntity -> ownerRestaurantEntity.toOwnerRestaurant());
    }

    @Override
    public OwnerRestaurant updateOwner(String id, OwnerRestaurantUpdate ownerRestaurantUpdate) {
        OwnerRestaurantEntity ownerRestaurantEntity = this.ownerRestaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not find this id: " + id));
        ownerRestaurantEntity.setName(ownerRestaurantUpdate.getName());
        ownerRestaurantEntity.setFamilyName(ownerRestaurantUpdate.getFamilyName());
        return ownerRestaurantRepository.save(ownerRestaurantEntity).toOwnerRestaurant();
    }
}
