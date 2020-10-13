package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

public interface PatientBuilder {

    interface Dni{
        Optionals dni(String dni);
    }
    interface Optionals{
        Optionals name(String name);
        Optionals surname(String name);
        Optionals pathologies(String pathology);
        Optionals illnessEntities(IllnessEntity illnessEntity);
        PatientEntity build();
    }
}
