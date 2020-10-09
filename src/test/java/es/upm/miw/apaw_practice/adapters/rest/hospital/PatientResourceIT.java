package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import es.upm.miw.apaw_practice.domain.models.hospital.PatientCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
class PatientResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        String[] pathologiesA = {"pathologieA", "pathlologieA2"};
        PatientCreation patientCreation = new PatientCreation("12345678A", "NameZ", "SurnameZ", pathologiesA);
        this.webTestClient
                .post()
                .uri(PatientResource.PATIENTS)
                .body(BodyInserters.fromValue(patientCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Patient.class)
                .value(Assertions::assertNotNull)
                .value(patientData -> assertNotNull(patientData.getId()));
    }
}
