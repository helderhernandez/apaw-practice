package es.upm.miw.apaw_practice.domain.services.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Bed;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.BedPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class BedService {

    private BedPersistence bedPersistence;

    @Autowired
    public BedService(BedPersistence bedPersistence){
        this.bedPersistence=bedPersistence;
    }

    public Bed updateOccupied(String id, Boolean occupied) {
        return this.bedPersistence.updateOccupied(id, occupied);
    }

    public Stream<Bed> findByNameWidthOfBeds(String name) {
        return this.bedPersistence.findByNameWidthOfBeds(name);
    }
}
