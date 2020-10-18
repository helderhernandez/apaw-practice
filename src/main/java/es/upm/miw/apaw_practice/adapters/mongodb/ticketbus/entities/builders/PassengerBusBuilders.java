package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.builders;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.PassengerBusEntity;

public interface PassengerBusBuilders {

    interface DocIdentify {
        Name docIdentify(String docIdentify);
    }

    interface Name {
        FamilyName name(String name);
    }

    interface FamilyName {
        Phone familyName(String familyName);
    }

    interface Phone {
        Email phone(String phone);
    }

    interface Email {
        Accesibility email(String email);
    }

    interface Accesibility {
        Optionals accesibility(Boolean accesibility);
    }

    interface Optionals {
        PassengerBusEntity build();
    }
}
