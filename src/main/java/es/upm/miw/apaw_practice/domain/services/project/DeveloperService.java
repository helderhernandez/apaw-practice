package es.upm.miw.apaw_practice.domain.services.project;

import es.upm.miw.apaw_practice.domain.models.project.Developer;
import es.upm.miw.apaw_practice.domain.persistence_ports.project.DeveloperPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {

    private DeveloperPersistence developerPersistence;

    @Autowired
    public DeveloperService(DeveloperPersistence developerPersistence) {
        this.developerPersistence = developerPersistence;
    }

    public Developer updateYearsOfExperience(String id, int yearsOfExperience) {
        return this.developerPersistence.updateYearsOfExperience(id, yearsOfExperience);
    }

}
