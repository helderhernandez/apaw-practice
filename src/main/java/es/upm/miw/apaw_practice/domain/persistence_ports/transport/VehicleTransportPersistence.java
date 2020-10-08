package es.upm.miw.apaw_practice.domain.persistence_ports.transport;

import es.upm.miw.apaw_practice.domain.models.transport.VehicleTransport;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTransportPersistence {
    VehicleTransport create(VehicleTransport vehicleTransport);
    VehicleTransport readByPlate(String plate);
}
