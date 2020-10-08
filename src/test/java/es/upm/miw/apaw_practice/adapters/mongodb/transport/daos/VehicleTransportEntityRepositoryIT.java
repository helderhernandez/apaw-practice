package es.upm.miw.apaw_practice.adapters.mongodb.transport.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class VehicleTransportEntityRepositoryIT {

    @Autowired
    private VehicleTransportRepository vehicleTransportRepository;

}
