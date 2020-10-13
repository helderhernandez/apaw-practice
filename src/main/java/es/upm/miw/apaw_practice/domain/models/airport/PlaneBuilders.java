package es.upm.miw.apaw_practice.domain.models.airport;

public interface PlaneBuilders {
    interface Id {
        Model id(String id);
    }

    interface Model {
        Capacity model(String model);
    }

    interface Capacity {
        Complete capacity(Integer capacity);
    }

    interface Complete {
        LicensePlate complete(Boolean complete);
    }

    interface LicensePlate {
        Build licensePlate(String licensePlate);
    }

    interface Build {
        Plane build();
    }
}
