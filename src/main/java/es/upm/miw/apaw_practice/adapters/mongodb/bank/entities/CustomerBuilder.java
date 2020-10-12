package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;

public interface CustomerBuilder {

    interface DNI{
        Name dni(String DNI);
    }

    interface Name{
        Optionals name(String name);
    }

    interface Optionals{
        Optionals phone(String phone);
        Optionals email(String email);
        CustomerEntity build();
    }
}
