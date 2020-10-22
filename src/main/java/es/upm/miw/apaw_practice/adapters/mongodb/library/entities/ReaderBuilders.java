package es.upm.miw.apaw_practice.adapters.mongodb.library.entities;

public interface ReaderBuilders {
    interface Name{
        Sex name(String name);
    }
    interface Sex{
        DNI sex(String sex);
    }
    interface DNI{
        Phone dni(String dni);
    }
    interface Phone{
        Optionals phone(String phone);
    }
    interface Optionals{
        Optionals email(String email);

        ReaderEntity build();
    }
}
