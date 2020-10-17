package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.AccidentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.OwnerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.TaxRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.CarRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.AccidentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.OwnerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.TaxEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.CarEntity;
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
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private AccidentRepository accidentRepository;
    @Autowired
    private TaxRepository taxRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- TransitTaxes Initial Load -----------");

        TaxEntity[] taxes = {
                TaxEntity.builder().idTax().refTax("TAX001").price(new BigDecimal("500.00")).description("Driving without a driver's license").paid(false).build(),
                TaxEntity.builder().idTax().refTax("TAX002").price(new BigDecimal("400.00")).description("Driving with excess alcohol").paid(true).build(),
                TaxEntity.builder().idTax().refTax("TAX003").price(new BigDecimal("200.00")).description("Using the mobile at the wheel").paid(false).build(),
                TaxEntity.builder().idTax().refTax("TAX004").price(new BigDecimal("50.00")).description("Throw any object on the road").paid(true).build()
        };
        taxRepository.saveAll(Arrays.asList(taxes));
        AccidentEntity[] accidents = {
                new AccidentEntity("001", "ACC001", LocalDateTime.of(2020, 10, 5, 5, 0), "Toledo"),
                new AccidentEntity("002", "ACC002", LocalDateTime.of(2017, 12, 24, 12, 30), "Madrid"),
                new AccidentEntity("003", "ACC003", LocalDateTime.of(2019, 10, 1, 7, 0), "Madrid"),
                new AccidentEntity("004", "ACC004", LocalDateTime.of(2020, 5, 8, 3, 0), "Toledo"),
                new AccidentEntity("005", "ACC005", LocalDateTime.of(2008, 5, 8, 3, 0), "Barcelona")
        };
        accidentRepository.saveAll(Arrays.asList(accidents));
        OwnerEntity[] owners = {
                OwnerEntity.builder().idOwner("ow1").dni("00000000A").name("Maria").familyName("Perez").build(),
                OwnerEntity.builder().idOwner("ow2").dni("00000000C").name("Jhon").familyName("Smith").build(),
                OwnerEntity.builder().idOwner("ow3").dni("00000000D").name("Celia").build(),
                OwnerEntity.builder().idOwner("ow4").dni("00000000E").name("Lucas").familyName("Lopez").build(),
                OwnerEntity.builder().idOwner("ow5").dni("00000000F").name("Delete").familyName("Delete").build(),

        };
        ownerRepository.saveAll(Arrays.asList(owners));
        CarEntity[] cars = {
                new CarEntity("01", "AAAA", "SEAT", List.of(accidents[0]), owners[0], List.of(taxes[0])),
                new CarEntity("02", "BBBB", "FORD", List.of(), owners[1], List.of(taxes[1], taxes[2], taxes[3])),
                new CarEntity("03", "CCCC", "PEUGEOT", List.of(), owners[2], List.of()),
                new CarEntity("04", "DDDD", "PEUGEOT", List.of(accidents[1], accidents[2], accidents[3]), owners[3], List.of()),
                new CarEntity("05", "EEEE", "NISAN", List.of(accidents[4]), owners[3], List.of())
        };
        carRepository.saveAll(Arrays.asList(cars));
    }

    public void deleteAll() {
        this.taxRepository.deleteAll();
        this.accidentRepository.deleteAll();
        this.ownerRepository.deleteAll();
        this.carRepository.deleteAll();
    }
}
