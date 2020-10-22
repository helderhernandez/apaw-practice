package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos.TreeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.TreeEntity;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.Tree;
import es.upm.miw.apaw_practice.domain.persistence_ports.tree_conservation.TreePersistence;
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
