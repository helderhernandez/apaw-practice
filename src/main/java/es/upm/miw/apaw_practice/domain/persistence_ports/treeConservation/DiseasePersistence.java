package es.upm.miw.apaw_practice.domain.persistence_ports.treeConservation;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Disease;
import es.upm.miw.apaw_practice.domain.models.treeConservation.DiseaseCreation;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface DiseasePersistence {

    Disease create(DiseaseCreation diseaseCreation);

    Disease readByName(String name);

    Stream<Disease> readAll();

    void deleteByName(String name);
}
