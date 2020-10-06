package es.upm.miw.apaw_practice.adapters.mongodb.project.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.project.daos.LabelRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.LabelEntity;
import es.upm.miw.apaw_practice.domain.models.project.Label;
import es.upm.miw.apaw_practice.domain.persistence_ports.project.LabelPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("labelPersistence")
public class LabelPersistenceMongodb implements LabelPersistence {

    private LabelRepository labelRepository;

    @Autowired
    public LabelPersistenceMongodb(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    public Label create(String name, String description) {
        return this.labelRepository
                .save(new LabelEntity(name, description))
                .toLabel();
    }

}
