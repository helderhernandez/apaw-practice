package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos.DiseaseRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.DiseaseEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.Disease;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.DiseaseCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.tree_conservation.DiseasePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

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
    public Stream<Disease> readAll() {
        return this.diseaseRepository.findAll().stream().map(DiseaseEntity::toDisease);
    }

    @Override
    public void deleteByName(String name) {
        this.diseaseRepository.deleteByName(name);
    }
}
