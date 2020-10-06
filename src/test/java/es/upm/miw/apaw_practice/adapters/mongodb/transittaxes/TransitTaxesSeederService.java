package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.AccidentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.OwnerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.TransitTaxesRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.VehicleRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.AccidentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.OwnerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.TransitTaxesEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.VehicleEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class TransitTaxesSeederService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private AccidentRepository accidentRepository;
    @Autowired
    private TransitTaxesRepository transitTaxesRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- TransitTaxes Initial Load -----------");

        TransitTaxesEntity [] taxes = {
                new TransitTaxesEntity("TAX001","Driving without a driver's license", new BigDecimal("500.00"),false),
                new TransitTaxesEntity("TAX002","Driving with excess alcohol", new BigDecimal("400.00"),true),
                new TransitTaxesEntity("TAX003","Using the mobile at the wheel", new BigDecimal("200.00"),false),
                new TransitTaxesEntity("TAX004","Throw any object on the road", new BigDecimal("50.00"),true)

        };
        transitTaxesRepository.saveAll(Arrays.asList(taxes));

        AccidentEntity [] accidents = {
                new AccidentEntity("ACC001", LocalDateTime.of(2020,10,05,5,0), "Toledo"),
                new AccidentEntity("ACC002", LocalDateTime.of(2017,12,24,12,30), "Madrid"),
                new AccidentEntity("ACC003", LocalDateTime.of(2019,10,1,7,0), "Madrid"),
                new AccidentEntity("ACC004", LocalDateTime.of(2020,5,8,3,0),"Toledo")
        };
        accidentRepository.saveAll(Arrays.asList(accidents));

        OwnerEntity [] owners = {
                new OwnerEntity("Maria", "00000000A", "Perez"),
                new OwnerEntity("Jhon", "00000000C", "Smith"),
                new OwnerEntity("Celia", "00000000D", "Guerrero"),

        };
        ownerRepository.saveAll(Arrays.asList(owners));

        VehicleEntity [] vehicles = {
                new VehicleEntity("AAAA", "SEAT",  List.of(accidents[0]),owners[0],List.of(taxes[0])),
                new VehicleEntity("BBBB", "FORD",  List.of(),owners[1],List.of(taxes[1], taxes[2],taxes[3])),
                new VehicleEntity("CCCC", "PEUGEOT",  List.of(),owners[2],List.of())

        };
        vehicleRepository.saveAll(Arrays.asList(vehicles));
    }
    public void deleteAll() {
        this.transitTaxesRepository.deleteAll();
        this.accidentRepository.deleteAll();
        this.ownerRepository.deleteAll();
        this.vehicleRepository.deleteAll();
    }
}
