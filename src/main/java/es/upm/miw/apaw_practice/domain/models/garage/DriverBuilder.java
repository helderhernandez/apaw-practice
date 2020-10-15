package es.upm.miw.apaw_practice.domain.models.garage;

import java.util.List;

public interface DriverBuilder {

    interface Id {
        Dni id(String id);
    }

    interface Dni {
        Name dni(String dni);
    }

    interface Name {
        Telephone name(String name);
    }

    interface Telephone {
        Email telephone(String telephone);
    }

    interface Email {
        GarageMember email(String email);
    }

    interface GarageMember {
        Vehicles garageMember(Boolean garageMember);
    }

    interface Vehicles {
        Build vehicles(List<Vehicle> vehicles);
    }

    interface Build {
        Driver build();
    }
}
