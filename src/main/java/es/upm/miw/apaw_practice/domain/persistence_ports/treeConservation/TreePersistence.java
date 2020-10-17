package es.upm.miw.apaw_practice.domain.persistence_ports.treeConservation;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Tree;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface TreePersistence {
    Stream<Tree> readAll();
}
