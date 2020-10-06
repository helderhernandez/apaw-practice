package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.DegreeRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.factory.DegreePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("degreePersistence")
public class DegreePersistenceMongodb implements DegreePersistence {

    private DegreeRepository degreeRepository;

    @Autowired
    public DegreePersistenceMongodb(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    @Override
    public void deleteById(String id) {
        this.degreeRepository.deleteById(id);
    }
}
