package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import es.upm.miw.apaw_practice.domain.models.hospital.PatientCreation;
import es.upm.miw.apaw_practice.domain.services.hospital.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PatientResource.PATIENTS)
public class PatientResource {
    static final String PATIENTS = "/hospital/patients";

    private PatientService patientService;

    @Autowired
    public PatientResource(PatientService patientService){
        this.patientService=patientService;
    }

    @PostMapping
    public Patient create(@RequestBody PatientCreation patientCreation){
        return this.patientService.create(patientCreation);
    }
}
