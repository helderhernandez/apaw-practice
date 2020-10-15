package es.upm.miw.apaw_practice.domain.services.treeConservation;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Disease;
import es.upm.miw.apaw_practice.domain.models.treeConservation.DiseaseCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.treeConservation.DiseasePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseaseService {
    private final DiseasePersistence diseasePersistence;

    @Autowired
    public DiseaseService(DiseasePersistence diseasePersistence) {
        this.diseasePersistence = diseasePersistence;
    }

    public Disease create(DiseaseCreation diseaseCreation) {
        return this.diseasePersistence.create(diseaseCreation);
    }

    public void delete(String name) {
        this.diseasePersistence.deleteByName(name);
    }

}
