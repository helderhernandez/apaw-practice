package es.upm.miw.apaw_practice.domain.services.transport;

import es.upm.miw.apaw_practice.domain.models.transport.VehicleTransport;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.VehicleTransportPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.WorkerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class VehicleTransportService {

    private final VehicleTransportPersistence vehicleTransportPersistence;
    private final WorkerPersistence workerPersistence;

    @Autowired
    public VehicleTransportService(VehicleTransportPersistence vehicleTransportPersistence, WorkerPersistence workerPersistence) {
        this.vehicleTransportPersistence = vehicleTransportPersistence;
        this.workerPersistence = workerPersistence;
    }

    public VehicleTransport create(VehicleTransport vehicleTransport) {
        return this.vehicleTransportPersistence.create(vehicleTransport);
    }

    public Stream<String> searchDistinctModelByDepartment(String name) {
        List<String> listofWorkers = this.workerPersistence.findByDepartmentName(name);
        return this.vehicleTransportPersistence.searchDistinctModelListofWorkers(listofWorkers);
    }
}
