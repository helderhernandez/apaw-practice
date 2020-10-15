package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos.InspectionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.InspectionEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.treeConservation.Inspection;
import es.upm.miw.apaw_practice.domain.persistence_ports.treeConservation.InspectionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("inspectionPersistence")
public class InspectionPersistenceMongodb implements InspectionPersistence {

    private final InspectionRepository inspectionRepository;

    @Autowired
    public InspectionPersistenceMongodb(InspectionRepository inspectionRepository) {
        this.inspectionRepository = inspectionRepository;
    }

    @Override
    public Inspection updateTreeStatus(String id, String treeStatus) {
        InspectionEntity inspectionEntity = this.inspectionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Inspection id: " + id));
        inspectionEntity.setTreeStatus(treeStatus);
        return this.inspectionRepository.save(inspectionEntity).toInspection();
    }

    @Override
    public Stream<Inspection> readAll() {
        return this.inspectionRepository.findAll().stream().map(InspectionEntity::toInspection);
    }
}
