package es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CarDealership;

public interface CarDealershipPersistence {
    CarDealership readByName(String name);
}
