package es.upm.miw.apaw_practice.domain.services.sportcentre;

import es.upm.miw.apaw_practice.domain.models.sportcentre.Instructor;
import es.upm.miw.apaw_practice.domain.models.sportcentre.InstructorCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre.InstructorPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre.SpecialityPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    private InstructorPersistence instructorPersistence;

    @Autowired
    public InstructorService(InstructorPersistence instructorPersistence) {
        this.instructorPersistence = instructorPersistence;
    }


    public Instructor create(InstructorCreation instructorCreation) {
        return this.instructorPersistence.create(instructorCreation);
    }
}
