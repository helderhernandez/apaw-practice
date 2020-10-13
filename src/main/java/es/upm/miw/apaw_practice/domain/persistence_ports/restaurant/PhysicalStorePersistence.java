package es.upm.miw.apaw_practice.domain.persistence_ports.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.PhysicalStore;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalStorePersistence {
    PhysicalStore create(PhysicalStore physicalStore);
}
