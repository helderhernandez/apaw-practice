package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.BedRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.BedEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.PatientEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hospital.Bed;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.BedPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("bedPersistence")
public class BedPersistenceMongodb implements BedPersistence {

    private BedRepository bedRepository;

    @Autowired
    public BedPersistenceMongodb(BedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    @Override
    public Bed updateOccupied(String id, Boolean occupied) {
        BedEntity bedEntity = this.bedRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Article id: " + id));
        bedEntity.setOccupied(occupied);
        return this.bedRepository.save(bedEntity).toBed();
    }

    @Override
    public Stream<Bed> findByNameWidthOfBeds(String name) {
        return this.bedRepository.findAll().stream()
                .filter(bedEntity -> bedEntity.getRoomEntity().getPatientEntities().stream()
                        .map(PatientEntity::getName)
                        .anyMatch(name::equals))
                .map(BedEntity::toBed);
    }
}

