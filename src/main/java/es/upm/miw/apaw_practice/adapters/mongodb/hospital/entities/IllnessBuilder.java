package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

public interface IllnessBuilder {

    interface Phase{
        Symptoms phase(Integer phase);
    }
    interface Symptoms{
        Symptoms symptoms(String symptom);
        Causes endSymptoms();
    }
    interface Causes{
        Causes causes(String cause);
        Contagious endCauses();
    }
    interface Contagious{
        Build contagious(Boolean contagious);
    }
    interface Build{
        IllnessEntity build();
    }
}
