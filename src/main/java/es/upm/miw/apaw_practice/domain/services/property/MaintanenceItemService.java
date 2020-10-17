package es.upm.miw.apaw_practice.domain.services.property;

import es.upm.miw.apaw_practice.domain.persistence_ports.property.MaintanenceItemPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintanenceItemService {
    private final MaintanenceItemPersistence maintanenceItemPersistence;

    @Autowired
    public MaintanenceItemService(MaintanenceItemPersistence maintanenceItemPersistence) {
        this.maintanenceItemPersistence = maintanenceItemPersistence;
    }

    public void delete(String id) {
        this.maintanenceItemPersistence.deleteById(id);
    }
}