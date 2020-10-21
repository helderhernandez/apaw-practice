package es.upm.miw.apaw_practice.domain.persistence_ports.tree_conservation;

import es.upm.miw.apaw_practice.domain.models.tree_conservation.Tree;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface TreePersistence {
    Stream<Tree> readAll();
}
