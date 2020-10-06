package es.upm.miw.apaw_practice.adapters.mongodb.transport;


import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.DepartmentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.ExtraRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.VehicleReopsitory;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.WorkerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.DepartmentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.ExtraEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.VehicleEntity;
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
    private VehicleReopsitory vehicleReopsitory;
    @Autowired
    private WorkerRepository workerRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Worker Initial Load -----------");
        ExtraEntity[] extras = {
                new ExtraEntity(1, true),
                new ExtraEntity(2, false),
                new ExtraEntity(3, true),
                new ExtraEntity(4, false),
                new ExtraEntity(5, true),
                new ExtraEntity(6, false)
        };
        this.extraRepository.saveAll(Arrays.asList(extras));
        WorkerEntity[] workers = {
                new WorkerEntity("name1", "telephone1", "dni1", Arrays.asList(extras[0], extras[1]) ),
                new WorkerEntity("name2", "telephone2", "dni2", Arrays.asList(extras[2], extras[3]) ),
                new WorkerEntity("name3", "telephone3", "dni3", Arrays.asList(extras[4], extras[5]) )
        };
        this.workerRepository.saveAll(Arrays.asList(workers));
        DepartmentEntity[] departments = {
                new DepartmentEntity("name1", "ubication1", Arrays.asList(workers[0], workers[1]) ),
                new DepartmentEntity("name2", "ubication2", Arrays.asList(workers[0], workers[2]) )
        };
        this.departmentRepository.saveAll(Arrays.asList(departments));
        VehicleEntity[] vehicles = {
                new VehicleEntity("brand1", "model1", "plate1", LocalDate.now(), workers[0]),
                new VehicleEntity("brand2", "model2", "plate2", LocalDate.now(), workers[1]),
                new VehicleEntity("brand3", "model3", "plate3", LocalDate.now(), workers[2])
        };
        this.vehicleReopsitory.saveAll(Arrays.asList(vehicles));
    }

    public void deleteAll() {
        this.vehicleReopsitory.deleteAll();
        this.departmentRepository.deleteAll();
        this.workerRepository.deleteAll();
        this.extraRepository.deleteAll();
    }
}
