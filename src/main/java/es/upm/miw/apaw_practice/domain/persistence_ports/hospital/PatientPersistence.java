package es.upm.miw.apaw_practice.domain.persistence_ports.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import es.upm.miw.apaw_practice.domain.models.hospital.PatientCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientPersistence {
    Patient create(PatientCreation patientCreation);
}
