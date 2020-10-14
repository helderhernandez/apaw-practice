package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos.DiseaseRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.DiseaseEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.treeConservation.Disease;
import es.upm.miw.apaw_practice.domain.models.treeConservation.DiseaseCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.treeConservation.DiseasePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("diseasePersistence")
public class DiseasePersistenceMongodb implements DiseasePersistence {
    private final DiseaseRepository diseaseRepository;

    @Autowired
    public DiseasePersistenceMongodb(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public Disease create(DiseaseCreation diseaseCreation) {
        return this.diseaseRepository.
                save(new DiseaseEntity(diseaseCreation)).toDisease();
    }

    @Override
    public Disease readByName(String name) {
        return this.diseaseRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Disease name: " + name))
                .toDisease();
    }

    @Override
    public void deleteByName(String name) {
        this.diseaseRepository.deleteByName(name);
    }
}
