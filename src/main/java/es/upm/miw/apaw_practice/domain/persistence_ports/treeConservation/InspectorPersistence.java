package es.upm.miw.apaw_practice.domain.persistence_ports.treeConservation;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Inspector;
import es.upm.miw.apaw_practice.domain.models.treeConservation.InspectorName;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface InspectorPersistence {
    Inspector updateName(InspectorName inspectorName);

    Stream<Inspector> readAll();
}
