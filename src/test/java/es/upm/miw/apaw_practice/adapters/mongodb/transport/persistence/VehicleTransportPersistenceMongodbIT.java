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
                ExtraEntity.builder("1")
                        .workedHours(1)
                        .paid(true)
                        .build(),
                ExtraEntity.builder("2")
                        .workedHours(2)
                        .paid(false)
                        .build()
        };
        WorkerEntity worker = WorkerEntity.builder()
                .name("nameTest")
                .telephone("telephoneTest")
                .dni("dniTest")
                .extraEntities(Arrays.asList(extras[0], extras[1]))
                .build();
        VehicleTransport vehicleTransport =
                new VehicleTransport("brandTest", "modelTest", "plateTest", LocalDate.now(), worker);
        this.vehicleTransportPersistence.create(vehicleTransport);
        VehicleTransport vehicleBD = this.vehicleTransportPersistence.readByPlate("plateTest");
        assertEquals("brandTest", vehicleBD.getBrand());
    }

}
