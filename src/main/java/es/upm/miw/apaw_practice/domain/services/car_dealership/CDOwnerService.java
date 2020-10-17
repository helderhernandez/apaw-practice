package es.upm.miw.apaw_practice.domain.services.car_dealership;

import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.CDOwnerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class CDOwnerService {

    private CDOwnerPersistence cdOwnerPersistence;

    @Autowired
    CDOwnerService(CDOwnerPersistence cdOwnerPersistence) {
        this.cdOwnerPersistence = cdOwnerPersistence;
    }

    public Stream<String> findOwnerByBrand(String brand) {
        return this.cdOwnerPersistence.findOwnerByBrand(brand);
    }
}
