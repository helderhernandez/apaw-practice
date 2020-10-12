package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos.TreeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.TreeEntity;
import es.upm.miw.apaw_practice.domain.models.treeConservation.Tree;
import es.upm.miw.apaw_practice.domain.persistence_ports.treeConservation.TreePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("treePersistence")
public class TreePersistenceMongodb implements TreePersistence {

    private final TreeRepository treeRepository;

    @Autowired
    public TreePersistenceMongodb(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    @Override
    public Stream<Tree> readAll() {
        return this.treeRepository.findAll().stream().map(TreeEntity::toTree);
    }
}
