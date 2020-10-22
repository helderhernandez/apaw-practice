package es.upm.miw.apaw_practice.adapters.mongodb.project.entities;

public interface DeveloperEntityBuilder {

    interface Name {
        Email name(String name);
    }

    interface Email {
        Optionals email(String email);
    }

    interface Optionals {

        Optionals yearsOfExperience(int yearsOfExperience);

        DeveloperEntity build();

    }

}
