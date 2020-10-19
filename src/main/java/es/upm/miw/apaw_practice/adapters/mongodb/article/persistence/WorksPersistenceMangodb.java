package es.upm.miw.apaw_practice.adapters.mongodb.article.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.article.daos.WorksRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.article.WorksPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("worksPersistence")
public class WorksPersistenceMangodb implements WorksPersistence {
    private final WorksRepository worksRepository;

    @Autowired
    public WorksPersistenceMangodb(WorksRepository worksRepository) {this.worksRepository = worksRepository; }

    @Override
    public void deleteById(String id) { this.worksRepository.deleteById(id); }
}
