package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities;

public interface ClientBuilder {

    interface Id {
        Name id(String id);
    }

    interface Name {
        Address name(String name);
    }

    interface Address {
        Phone address(String address);
    }

    interface Phone {
        EndBuilder phone(String phone);
    }

    interface EndBuilder {
        ClientEntity build();
    }
}
