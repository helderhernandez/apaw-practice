package es.upm.miw.apaw_practice.domain.services.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.PhysicalStore;
import es.upm.miw.apaw_practice.domain.persistence_ports.restaurant.PhysicalStorePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhysicalStoreService {
    private PhysicalStorePersistence physicalStorePersistence;

    @Autowired
    public PhysicalStoreService(PhysicalStorePersistence physicalStorePersistence){
        this.physicalStorePersistence = physicalStorePersistence;
    }

    public PhysicalStore create(PhysicalStore physicalStore){
        return this.physicalStorePersistence.create(physicalStore);
    }
}
