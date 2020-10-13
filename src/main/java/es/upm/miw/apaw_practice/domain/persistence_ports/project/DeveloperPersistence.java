package es.upm.miw.apaw_practice.domain.persistence_ports.project;

import es.upm.miw.apaw_practice.domain.models.project.Developer;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperPersistence {

    Developer updateYearsOfExperience(String id, int yearsOfExperience);

}
