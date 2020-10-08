package es.upm.miw.apaw_practice.domain.services.transport;

import es.upm.miw.apaw_practice.domain.models.transport.VehicleTransport;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.VehicleTransportPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleTransportService {

    private VehicleTransportPersistence vehicleTransportPersistence;

    @Autowired
    public VehicleTransportService(VehicleTransportPersistence vehicleTransportPersistence) {
        this.vehicleTransportPersistence = vehicleTransportPersistence;
    }

    public VehicleTransport create(VehicleTransport vehicleTransport) {
        return this.vehicleTransportPersistence.create(vehicleTransport);
    }
}
