package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.BedRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.PatientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.BedEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.PatientEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.hospital.Bed;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.BedPersistence;
import org.apache.logging.log4j.LogManager;
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
    public Stream<String> findByNameWidthOfBeds(String name) {
        return this.bedRepository.findAll().stream()
                .filter(bedEntity -> bedEntity.getRoomEntity().getPatientEntities().stream()
                        .anyMatch(patientEntity -> name.equals(patientEntity.getName())))
                .map(BedEntity::getWidth).map(String::valueOf).distinct()
                .peek(x -> LogManager.getLogger(this.getClass()).info("__RESULTADO__: " + x));
    }
}
