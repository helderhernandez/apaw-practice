package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities;


public interface StaffBuilders {
    interface FirstName {
        LastName firstName(String firstName);
    }

    interface LastName {
        Dni lastName(String lastName);
    }

    interface Dni {
        Optionals dni(String dni);
    }

    interface Optionals {
        Optionals age(Integer age);

        Optionals phone(Integer phone);

        Optionals post(String post);

        StaffEntity build();

    }
}
