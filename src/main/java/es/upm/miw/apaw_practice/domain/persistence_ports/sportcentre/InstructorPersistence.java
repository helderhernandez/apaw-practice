package es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre;

import es.upm.miw.apaw_practice.domain.models.sportcentre.Instructor;
import es.upm.miw.apaw_practice.domain.models.sportcentre.InstructorCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorPersistence {

    Instructor create(InstructorCreation instructorCreation);

    Instructor readBySpecialityTitle(String title);
}
