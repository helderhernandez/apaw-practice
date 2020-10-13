package es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CDEmployee;

public interface CDEmployeePersistence {
    void deleteById(String id);

    CDEmployee readById(String id);

    CDEmployee update(CDEmployee employee);
}
