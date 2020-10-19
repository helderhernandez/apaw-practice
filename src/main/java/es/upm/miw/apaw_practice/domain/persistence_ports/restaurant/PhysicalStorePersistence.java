package es.upm.miw.apaw_practice.domain.persistence_ports.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.PhysicalStore;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PhysicalStorePersistence {
    PhysicalStore create(PhysicalStore physicalStore);

    void deletePhysicalStore(String address);

    Stream<PhysicalStore> findAddressPhysicalStoreWithAFoodTypeScoreHigherThan(String idFoodType, Double score);
}
