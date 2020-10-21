package es.upm.miw.apaw_practice.domain.persistence_ports.tree_conservation;

import es.upm.miw.apaw_practice.domain.models.tree_conservation.Disease;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.DiseaseCreation;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface DiseasePersistence {

    Disease create(DiseaseCreation diseaseCreation);

    Disease readByName(String name);

    Stream<Disease> readAll();

    void deleteByName(String name);
}
