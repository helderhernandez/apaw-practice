package es.upm.miw.apaw_practice.domain.services.treeConservation;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Inspection;
import es.upm.miw.apaw_practice.domain.models.treeConservation.Tree;
import es.upm.miw.apaw_practice.domain.persistence_ports.treeConservation.TreePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class TreeService {
    private final TreePersistence treePersistence;

    @Autowired
    public TreeService(TreePersistence treePersistence) {
        this.treePersistence = treePersistence;
    }

    public Stream<Tree> readAll() {
        return this.treePersistence.readAll();
    }

    public Stream<Tree> findByInspectorDni(String dni) {
        return this.treePersistence.readAll()
                .filter(tree -> tree.getInspections().stream()
                        .map(Inspection::getDni)
                        .anyMatch(dni::equals));
    }
}
