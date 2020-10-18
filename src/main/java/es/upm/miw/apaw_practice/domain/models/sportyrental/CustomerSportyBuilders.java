package es.upm.miw.apaw_practice.domain.models.sportyrental;

public interface CustomerSportyBuilders {

    interface IdCustomer {
        Dni idCustomer(String idCustomer);
    }

    interface Dni {
        Name dni(String dni);
    }

    interface Name {
        Optionals name(String name);
    }

    interface Optionals {
        Optionals surnames(String surnames);

        Optionals email(String email);

        Optionals phone(String phone);

        CustomerSporty build();
    }
}
