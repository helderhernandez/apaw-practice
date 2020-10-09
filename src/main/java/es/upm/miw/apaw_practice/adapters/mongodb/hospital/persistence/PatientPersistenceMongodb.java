package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.PatientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.PatientEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import es.upm.miw.apaw_practice.domain.models.hospital.PatientCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.PatientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("patientPersistence")
public class PatientPersistenceMongodb implements PatientPersistence {

    private PatientRepository patientRepository;

    @Autowired
    public PatientPersistenceMongodb(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient create(PatientCreation patientCreation) {
        this.assertDniNotExist(patientCreation.getDni());
        return this.patientRepository
                .save(new PatientEntity(patientCreation))
                .toPatient();
    }

    private void assertDniNotExist(String dni) {
        this.patientRepository
                .findByDni(dni)
                .ifPresent(patient -> {
                    throw new ConflictException("Dni exist: " + dni);
                });
    }
}
