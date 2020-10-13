package es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.car_dealership.CDBrandDto;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicle;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicleCreation;

public interface CDVehiclePersistence {
    CDVehicle create(CDVehicleCreation vehicleCreation);

    CDVehicle update(CDVehicle vehicle);

    CDVehicle updateBrand(String frameNumber, String brand);
}
