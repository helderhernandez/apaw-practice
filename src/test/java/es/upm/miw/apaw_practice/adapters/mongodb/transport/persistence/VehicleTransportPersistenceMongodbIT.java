package es.upm.miw.apaw_practice.adapters.mongodb.transport.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.ExtraEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.WorkerEntity;
import es.upm.miw.apaw_practice.domain.models.transport.VehicleTransport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class VehicleTransportPersistenceMongodbIT {

    @Autowired
    private VehicleTransportPersistenceMongodb vehicleTransportPersistence;

    @Test
    void testCreateAndRead() {
        ExtraEntity[] extras = {
                new ExtraEntity(1, true),
                new ExtraEntity(2, false)
        };
        WorkerEntity worker =
                new WorkerEntity("nameTest", "telephoneTest", "dniTest", Arrays.asList(extras[0], extras[1]) );
        VehicleTransport vehicleTransport =
                new VehicleTransport("brandTest","modelTest","plateTest", LocalDate.now(), worker);
        this.vehicleTransportPersistence.create(vehicleTransport);
        VehicleTransport vehicleBD = this.vehicleTransportPersistence.readByPlate("plateTest");
        assertEquals("brandTest", vehicleBD.getBrand());
    }

}
