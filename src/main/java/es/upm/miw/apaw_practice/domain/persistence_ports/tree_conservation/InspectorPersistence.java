package es.upm.miw.apaw_practice.domain.persistence_ports.tree_conservation;

import es.upm.miw.apaw_practice.domain.models.tree_conservation.Inspector;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.InspectorName;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface InspectorPersistence {
    Inspector updateName(InspectorName inspectorName);

    Stream<Inspector> readAll();
}
