package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos.InstructorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos.SpecialityRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.InstructorEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Instructor;
import es.upm.miw.apaw_practice.domain.models.sportcentre.InstructorCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre.InstructorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("instructorPersistence")
public class InstructorPersistenceMongodb implements InstructorPersistence {

    private InstructorRepository instructorRepository;

    @Autowired
    public InstructorPersistenceMongodb(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public void assertDniNotExist(String dni) {
        this.instructorRepository
                .findByDni(dni)
                .ifPresent(instructor -> {
                    throw new ConflictException("Dni exist: " + dni);
                });
    }

    @Override
    public Instructor create(InstructorCreation instructorCreation) {
        this.assertDniNotExist(instructorCreation.getDni());
        return this.instructorRepository
                .save(new InstructorEntity(instructorCreation))
                .toInstructor();
    }

    @Override
    public Instructor readBySpecialityTitle(String title) {
        return this.instructorRepository.findAll().stream()
                .filter(instructor -> instructor.getSpecialities().stream()
                        .anyMatch(speciality -> speciality.getTitle().equals(title)))
                .findFirst().get().toInstructor();
    }

}
