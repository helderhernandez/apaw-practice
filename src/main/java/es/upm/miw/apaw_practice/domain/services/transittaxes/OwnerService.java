package es.upm.miw.apaw_practice.domain.services.transittaxes;

import es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes.OwnerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private OwnerPersistence ownerPersitence;

    @Autowired
    public OwnerService(OwnerPersistence ownerPersitence) {
        this.ownerPersitence = ownerPersitence;
    }

    public void delete(String id) {
        this.ownerPersitence.deleteById(id);
    }
}
