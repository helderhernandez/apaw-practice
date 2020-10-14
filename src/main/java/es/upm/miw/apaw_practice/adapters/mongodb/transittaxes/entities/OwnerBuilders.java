package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities;

public interface OwnerBuilders {

    interface Id {
        Dni idOwner(String id);
    }

    interface Dni {
        Optatives dni(String dni);
    }

    interface Optatives {

        Optatives name(String name);

        Optatives familyName(String familyName);

        OwnerEntity build();
    }
}
