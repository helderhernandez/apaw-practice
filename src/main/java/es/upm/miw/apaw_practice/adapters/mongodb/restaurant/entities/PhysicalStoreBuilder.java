package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities;

import java.time.LocalDateTime;

public interface PhysicalStoreBuilder {

    interface address {
        Optionals address(String address);
    }

    interface Optionals {
        Optionals size(Integer size);
        Optionals terrace (Boolean terrace);
        Optionals opening (LocalDateTime opening);
        PhysicalStoreEntity build();
    }
}
