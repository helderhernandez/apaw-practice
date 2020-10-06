package es.upm.miw.apaw_practice.adapters.mongodb.project.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.project.daos.DeveloperRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.DeveloperEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.project.Developer;
import es.upm.miw.apaw_practice.domain.persistence_ports.project.DeveloperPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("developerPersistence")
public class DeveloperPersistenceMongodb implements DeveloperPersistence {

    private DeveloperRepository developerRepository;

    @Autowired
    public DeveloperPersistenceMongodb(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public Developer updateYearsOfExperience(String id, int yearsOfExperience) {
        DeveloperEntity developerEntity = this.developerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Developer id: " + id));
        developerEntity.setYearsOfExperience(yearsOfExperience);
        return this.developerRepository.save(developerEntity).toDeveloper();
    }
}
