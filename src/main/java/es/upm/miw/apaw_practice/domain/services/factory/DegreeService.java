package es.upm.miw.apaw_practice.domain.services.factory;

import es.upm.miw.apaw_practice.domain.persistence_ports.factory.DegreePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DegreeService {

    private DegreePersistence degreePersistence;

    @Autowired
    public DegreeService(DegreePersistence degreePersistence) {
        this.degreePersistence = degreePersistence;
    }

    public void delete(String id) {
        this.degreePersistence.deleteById(id);
    }
}
