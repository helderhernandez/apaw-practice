package es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CarDealership;

import java.util.List;

public interface CarDealershipPersistence {
    CarDealership readByName(String name);
}
