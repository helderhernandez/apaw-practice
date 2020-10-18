package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos.InspectorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.InspectorEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.treeConservation.Inspector;
import es.upm.miw.apaw_practice.domain.models.treeConservation.InspectorName;
import es.upm.miw.apaw_practice.domain.persistence_ports.treeConservation.InspectorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("inspectorPersistence")
public class InspectorPersistenceMongodb implements InspectorPersistence {

    private final InspectorRepository inspectorRepository;

    @Autowired
    public InspectorPersistenceMongodb(InspectorRepository inspectorRepository) {
        this.inspectorRepository = inspectorRepository;
    }

    @Override
    public Inspector updateName(InspectorName inspectorName) {
        InspectorEntity inspectorEntity = this.inspectorRepository.findByDni(inspectorName.getDni())
                .orElseThrow(() -> new NotFoundException("Inspection dni: " + inspectorName.getDni()));
        inspectorEntity.setFirstName(inspectorName.getFirstName());
        inspectorEntity.setLastName(inspectorName.getLastName());
        return this.inspectorRepository.save(inspectorEntity).toInspector();
    }

    @Override
    public Stream<Inspector> readAll() {
        return this.inspectorRepository.findAll().stream()
                .map(InspectorEntity::toInspector);
    }
}
