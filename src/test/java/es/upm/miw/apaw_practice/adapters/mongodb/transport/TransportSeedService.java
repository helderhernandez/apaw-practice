package es.upm.miw.apaw_practice.adapters.mongodb.transport;


import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.DepartmentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.ExtraRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.VehicleTransportRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.WorkerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.DepartmentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.ExtraEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.VehicleTransportEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.WorkerEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class TransportSeedService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ExtraRepository extraRepository;
    @Autowired
    private VehicleTransportRepository vehicleTransportRepository;
    @Autowired
    private WorkerRepository workerRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Worker Initial Load -----------");
        ExtraEntity[] extras = {
                ExtraEntity.builder("1")
                        .workedHours(1)
                        .paid(true)
                        .build(),
                ExtraEntity.builder("2")
                        .workedHours(2)
                        .paid(false)
                        .build(),
                ExtraEntity.builder("3")
                        .workedHours(3)
                        .paid(true)
                        .build(),
                ExtraEntity.builder("4")
                        .workedHours(4)
                        .paid(false)
                        .build(),
                ExtraEntity.builder("5")
                        .workedHours(5)
                        .paid(true)
                        .build(),
                ExtraEntity.builder("6")
                        .workedHours(6)
                        .paid(false)
                        .build()
        };
        this.extraRepository.saveAll(Arrays.asList(extras));
        WorkerEntity[] workers = {
                WorkerEntity.builder()
                        .name("name1")
                        .telephone("telephone1")
                        .dni("dni1")
                        .extraEntities(Arrays.asList(extras[0], extras[1]))
                        .build(),
                WorkerEntity.builder()
                        .name("name2")
                        .telephone("telephone2")
                        .dni("dni2")
                        .extraEntities(Arrays.asList(extras[2], extras[3]))
                        .build(),
                WorkerEntity.builder()
                        .name("name3")
                        .telephone("telephone3")
                        .dni("dni3")
                        .extraEntities(Arrays.asList(extras[4], extras[5]))
                        .build(),
        };
        this.workerRepository.saveAll(Arrays.asList(workers));
        DepartmentEntity[] departments = {
                new DepartmentEntity("name1", "ubication1", Arrays.asList(workers[0], workers[1]) ),
                new DepartmentEntity("name2", "ubication2", Arrays.asList(workers[0], workers[2]) )
        };
        this.departmentRepository.saveAll(Arrays.asList(departments));
        VehicleTransportEntity[] vehicles = {
                VehicleTransportEntity.builder("plate1")
                        .brand("brand1")
                        .model("model1")
                        .boughtDate(LocalDate.now())
                        .workerEntity(workers[0])
                        .build(),
                VehicleTransportEntity.builder("plate2")
                        .brand("brand2").model("model2")
                        .boughtDate(LocalDate.now())
                        .workerEntity(workers[1])
                        .build(),
                VehicleTransportEntity.builder("plate3")
                        .brand("brand3")
                        .model("model3")
                        .boughtDate(LocalDate.now())
                        .workerEntity(workers[2])
                        .build()
        };
        this.vehicleTransportRepository.saveAll(Arrays.asList(vehicles));
    }

    public void deleteAll() {
        this.vehicleTransportRepository.deleteAll();
        this.departmentRepository.deleteAll();
        this.workerRepository.deleteAll();
        this.extraRepository.deleteAll();
    }
}
