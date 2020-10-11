package es.upm.miw.apaw_practice.adapters.mongodb.transport.entities;

import java.util.List;

public interface WorkerBuilder {

    interface Name {
        Telephone name(String name);
    }

    interface Telephone {
        Dni telephone(String telephone);
    }

    interface Dni {
        Optionals dni(String dni);
    }

    interface Optionals {
        Optionals extraEntities(List<ExtraEntity> extraEntities);

        WorkerEntity build();
    }
}
