package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities;

public interface CDVehicleBuilder {

    interface Brand {
        Type brand(String brand);
    }

    interface Type {
        Optionals type(String type);
    }

    interface Optionals {
        Optionals frameNumber(String frameNumber);
        Optionals unused(Boolean unused);
        Optionals year(Integer year);
        CDVehicleEntity build();
    }

}
