package es.upm.miw.apaw_practice.adapters.mongodb.garage.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.daos.MechanicRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.MechanicEntity;
import es.upm.miw.apaw_practice.domain.models.garage.Mechanic;
import es.upm.miw.apaw_practice.domain.persistence_ports.garage.MechanicPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("mechanicPersistence")
public class MechanicPersistenceMongodb implements MechanicPersistence {

    private final MechanicRepository mechanicRepository;

    @Autowired
    public MechanicPersistenceMongodb(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    @Override
    public Stream<Mechanic> readAll() {
        return this.mechanicRepository.findAll().stream().map(MechanicEntity::toMechanic);
    }
}
