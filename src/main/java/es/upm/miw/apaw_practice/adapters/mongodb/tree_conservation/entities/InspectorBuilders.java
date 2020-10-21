package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities;

public interface InspectorBuilders {
    interface Dni {
        FirstName dni(String dni);
    }

    interface FirstName {
        LastName firstName(String firstName);
    }

    interface LastName {
        Age lastName(String lastName);
    }

    interface Age {
        Optionals age(Integer age);
    }

    interface Optionals {
        Optionals email(String email);

        Optionals phoneNumber(String phoneNumber);

        InspectorEntity build();
    }
}
