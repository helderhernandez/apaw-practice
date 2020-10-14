package es.upm.miw.apaw_practice.adapters.mongodb.property.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.MaintanenceItemRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.property.MaintanenceItemPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("maintanenceItemPersistence")
public class MaintanenceItemPersistenceMongodb implements MaintanenceItemPersistence {
    private final MaintanenceItemRepository maintanenceItemRepository;

    @Autowired
    public MaintanenceItemPersistenceMongodb(MaintanenceItemRepository maintanenceItemRepository) {
        this.maintanenceItemRepository = maintanenceItemRepository;
    }

    //@Override
    public void deleteById(String id) {
        this.maintanenceItemRepository.deleteById(id);
    }
}