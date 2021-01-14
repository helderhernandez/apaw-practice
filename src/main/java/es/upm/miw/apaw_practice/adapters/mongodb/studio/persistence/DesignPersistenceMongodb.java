package es.upm.miw.apaw_practice.adapters.mongodb.studio.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.studio.daos.DesignRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.ConsumerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.DesignEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.TattoistEntity;
import es.upm.miw.apaw_practice.domain.models.studio.Consumer;
import es.upm.miw.apaw_practice.domain.models.studio.Design;
import es.upm.miw.apaw_practice.domain.models.studio.DesignCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.studio.DesignPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("designPersistence")
public class DesignPersistenceMongodb implements DesignPersistence {

    private final DesignRepository designRepository;

    @Autowired
    public DesignPersistenceMongodb(DesignRepository designRepository) {
        this.designRepository = designRepository;
    }

    @Override
    public Design create(DesignCreation designCreation) {
        return this
                .designRepository
                .save(new DesignEntity(designCreation))
                .toDesign();
    }

    @Override
    public Stream<Consumer> findConsumersByTypeDesign(String type) {
        return this.designRepository.findAll()
                .stream()
                .filter(design -> design.getType().equals(type))
                .map(DesignEntity::getTattoistEntities)
                .flatMap(Collection::stream)
                .map(TattoistEntity::getConsumerEntities)
                .flatMap(Collection::stream)
                .map(ConsumerEntity::toConsumer);
    }


}
